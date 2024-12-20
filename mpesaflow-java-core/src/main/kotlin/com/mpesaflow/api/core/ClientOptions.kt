// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.core

import com.fasterxml.jackson.databind.json.JsonMapper
import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.ListMultimap
import com.mpesaflow.api.core.http.HttpClient
import com.mpesaflow.api.core.http.RetryingHttpClient
import java.time.Clock

class ClientOptions
private constructor(
    private val originalHttpClient: HttpClient,
    @get:JvmName("httpClient") val httpClient: HttpClient,
    @get:JvmName("jsonMapper") val jsonMapper: JsonMapper,
    @get:JvmName("clock") val clock: Clock,
    @get:JvmName("baseUrl") val baseUrl: String,
    @get:JvmName("appApiKey") val appApiKey: String?,
    @get:JvmName("rootApiKey") val rootApiKey: String?,
    @get:JvmName("headers") val headers: ListMultimap<String, String>,
    @get:JvmName("queryParams") val queryParams: ListMultimap<String, String>,
    @get:JvmName("responseValidation") val responseValidation: Boolean,
    @get:JvmName("maxRetries") val maxRetries: Int,
) {

    fun toBuilder() = Builder().from(this)

    companion object {

        const val PRODUCTION_URL = "https://api.mpesaflow.com"

        const val SANDBOX_URL = "https://sandbox-api.mpesaflow.com"

        @JvmStatic fun builder() = Builder()

        @JvmStatic fun fromEnv(): ClientOptions = builder().fromEnv().build()
    }

    class Builder {

        private var httpClient: HttpClient? = null
        private var jsonMapper: JsonMapper? = null
        private var clock: Clock = Clock.systemUTC()
        private var baseUrl: String = PRODUCTION_URL
        private var headers: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var queryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var responseValidation: Boolean = false
        private var maxRetries: Int = 2
        private var appApiKey: String? = null
        private var rootApiKey: String? = null

        @JvmSynthetic
        internal fun from(clientOptions: ClientOptions) = apply {
            httpClient = clientOptions.originalHttpClient
            jsonMapper = clientOptions.jsonMapper
            clock = clientOptions.clock
            baseUrl = clientOptions.baseUrl
            headers =
                clientOptions.headers.asMap().mapValuesTo(mutableMapOf()) { (_, value) ->
                    value.toMutableList()
                }
            queryParams =
                clientOptions.queryParams.asMap().mapValuesTo(mutableMapOf()) { (_, value) ->
                    value.toMutableList()
                }
            responseValidation = clientOptions.responseValidation
            maxRetries = clientOptions.maxRetries
            appApiKey = clientOptions.appApiKey
            rootApiKey = clientOptions.rootApiKey
        }

        fun httpClient(httpClient: HttpClient) = apply { this.httpClient = httpClient }

        fun jsonMapper(jsonMapper: JsonMapper) = apply { this.jsonMapper = jsonMapper }

        fun baseUrl(baseUrl: String) = apply { this.baseUrl = baseUrl }

        fun clock(clock: Clock) = apply { this.clock = clock }

        fun headers(headers: Map<String, Iterable<String>>) = apply {
            this.headers.clear()
            putAllHeaders(headers)
        }

        fun putHeader(name: String, value: String) = apply {
            this.headers.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.headers.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(headers: Map<String, Iterable<String>>) = apply {
            headers.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.headers.put(name, mutableListOf()) }

        fun queryParams(queryParams: Map<String, Iterable<String>>) = apply {
            this.queryParams.clear()
            putAllQueryParams(queryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.queryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.queryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(queryParams: Map<String, Iterable<String>>) = apply {
            queryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply { this.queryParams.put(name, mutableListOf()) }

        fun responseValidation(responseValidation: Boolean) = apply {
            this.responseValidation = responseValidation
        }

        fun maxRetries(maxRetries: Int) = apply { this.maxRetries = maxRetries }

        fun appApiKey(appApiKey: String?) = apply { this.appApiKey = appApiKey }

        fun rootApiKey(rootApiKey: String?) = apply { this.rootApiKey = rootApiKey }

        fun fromEnv() = apply {
            System.getenv("APP_API_KEY")?.let { appApiKey(it) }
            System.getenv("ROOT_API_KEY")?.let { rootApiKey(it) }
        }

        fun build(): ClientOptions {
            checkNotNull(httpClient) { "`httpClient` is required but was not set" }

            val headers = ArrayListMultimap.create<String, String>()
            val queryParams = ArrayListMultimap.create<String, String>()
            headers.put("X-Stainless-Lang", "java")
            headers.put("X-Stainless-Arch", getOsArch())
            headers.put("X-Stainless-OS", getOsName())
            headers.put("X-Stainless-OS-Version", getOsVersion())
            headers.put("X-Stainless-Package-Version", getPackageVersion())
            headers.put("X-Stainless-Runtime", "JRE")
            headers.put("X-Stainless-Runtime-Version", getJavaVersion())
            if (!appApiKey.isNullOrEmpty()) {
                headers.put("X-App-Api-Key", appApiKey)
            }
            if (!rootApiKey.isNullOrEmpty()) {
                headers.put("X-Root-Api-Key", rootApiKey)
            }
            this.headers.forEach(headers::replaceValues)
            this.queryParams.forEach(queryParams::replaceValues)

            return ClientOptions(
                httpClient!!,
                RetryingHttpClient.builder()
                    .httpClient(httpClient!!)
                    .clock(clock)
                    .maxRetries(maxRetries)
                    .build(),
                jsonMapper ?: jsonMapper(),
                clock,
                baseUrl,
                appApiKey,
                rootApiKey,
                headers.toUnmodifiable(),
                queryParams.toUnmodifiable(),
                responseValidation,
                maxRetries,
            )
        }
    }
}
