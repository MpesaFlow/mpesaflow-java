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
    @get:JvmName("httpClient") val httpClient: HttpClient,
    @get:JvmName("jsonMapper") val jsonMapper: JsonMapper,
    @get:JvmName("clock") val clock: Clock,
    @get:JvmName("baseUrl") val baseUrl: String,
    @get:JvmName("bearerToken") val bearerToken: String,
    @get:JvmName("headers") val headers: ListMultimap<String, String>,
    @get:JvmName("queryParams") val queryParams: ListMultimap<String, String>,
    @get:JvmName("responseValidation") val responseValidation: Boolean,
) {

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
        private var bearerToken: String? = null

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

        fun bearerToken(bearerToken: String) = apply { this.bearerToken = bearerToken }

        fun fromEnv() = apply { System.getenv("MPESAFLOW_API_TOKEN")?.let { bearerToken(it) } }

        fun build(): ClientOptions {
            checkNotNull(httpClient) { "`httpClient` is required but was not set" }
            checkNotNull(bearerToken) { "`bearerToken` is required but was not set" }

            val headers = ArrayListMultimap.create<String, String>()
            val queryParams = ArrayListMultimap.create<String, String>()
            headers.put("X-Stainless-Lang", "java")
            headers.put("X-Stainless-Arch", getOsArch())
            headers.put("X-Stainless-OS", getOsName())
            headers.put("X-Stainless-OS-Version", getOsVersion())
            headers.put("X-Stainless-Package-Version", getPackageVersion())
            headers.put("X-Stainless-Runtime-Version", getJavaVersion())
            if (!bearerToken.isNullOrEmpty()) {
                headers.put("Authorization", "Bearer ${bearerToken}")
            }
            this.headers.forEach(headers::replaceValues)
            this.queryParams.forEach(queryParams::replaceValues)

            return ClientOptions(
                RetryingHttpClient.builder()
                    .httpClient(httpClient!!)
                    .clock(clock)
                    .maxRetries(maxRetries)
                    .build(),
                jsonMapper ?: jsonMapper(),
                clock,
                baseUrl,
                bearerToken!!,
                headers.toUnmodifiable(),
                queryParams.toUnmodifiable(),
                responseValidation,
            )
        }
    }
}
