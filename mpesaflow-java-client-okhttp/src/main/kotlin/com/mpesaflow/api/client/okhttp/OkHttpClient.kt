package com.mpesaflow.api.client.okhttp

import com.google.common.collect.ListMultimap
import com.google.common.collect.MultimapBuilder
import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.core.http.HttpClient
import com.mpesaflow.api.core.http.HttpMethod
import com.mpesaflow.api.core.http.HttpRequest
import com.mpesaflow.api.core.http.HttpRequestBody
import com.mpesaflow.api.core.http.HttpResponse
import com.mpesaflow.api.errors.MpesaflowIoException
import java.io.IOException
import java.io.InputStream
import java.net.Proxy
import java.time.Duration
import java.util.concurrent.CompletableFuture
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Headers
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okio.BufferedSink

class OkHttpClient
private constructor(private val okHttpClient: okhttp3.OkHttpClient, private val baseUrl: HttpUrl) :
    HttpClient {

    private fun getClient(requestOptions: RequestOptions): okhttp3.OkHttpClient {
        val timeout = requestOptions.timeout ?: return okHttpClient
        return okHttpClient
            .newBuilder()
            .connectTimeout(timeout)
            .readTimeout(timeout)
            .writeTimeout(timeout)
            .callTimeout(if (timeout.seconds == 0L) timeout else timeout.plusSeconds(30))
            .build()
    }

    override fun execute(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): HttpResponse {
        val call = getClient(requestOptions).newCall(request.toRequest())

        return try {
            call.execute().toResponse()
        } catch (e: IOException) {
            throw MpesaflowIoException("Request failed", e)
        } finally {
            request.body?.close()
        }
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        val future = CompletableFuture<HttpResponse>()

        request.body?.run { future.whenComplete { _, _ -> close() } }

        val call = getClient(requestOptions).newCall(request.toRequest())
        call.enqueue(
            object : Callback {
                override fun onResponse(call: Call, response: Response) {
                    future.complete(response.toResponse())
                }

                override fun onFailure(call: Call, e: IOException) {
                    future.completeExceptionally(MpesaflowIoException("Request failed", e))
                }
            }
        )

        return future
    }

    override fun close() {
        okHttpClient.dispatcher.executorService.shutdown()
        okHttpClient.connectionPool.evictAll()
        okHttpClient.cache?.close()
    }

    private fun HttpRequest.toRequest(): Request {
        var body: RequestBody? = body?.toRequestBody()
        // OkHttpClient always requires a request body for PUT and POST methods.
        if (body == null && (method == HttpMethod.PUT || method == HttpMethod.POST)) {
            body = "".toRequestBody()
        }

        val builder = Request.Builder().url(toUrl()).method(method.name, body)
        headers.forEach(builder::header)

        return builder.build()
    }

    private fun HttpRequest.toUrl(): String {
        url?.let {
            return it
        }

        val builder = baseUrl.newBuilder()
        pathSegments.forEach(builder::addPathSegment)
        queryParams.forEach(builder::addQueryParameter)

        return builder.toString()
    }

    private fun HttpRequestBody.toRequestBody(): RequestBody {
        val mediaType = contentType()?.toMediaType()
        val length = contentLength()

        return object : RequestBody() {
            override fun contentType(): MediaType? = mediaType

            override fun contentLength(): Long = length

            override fun isOneShot(): Boolean = !repeatable()

            override fun writeTo(sink: BufferedSink) = writeTo(sink.outputStream())
        }
    }

    private fun Response.toResponse(): HttpResponse {
        val headers = headers.toHeaders()

        return object : HttpResponse {
            override fun statusCode(): Int = code

            override fun headers(): ListMultimap<String, String> = headers

            override fun body(): InputStream = body!!.byteStream()

            override fun close() = body!!.close()
        }
    }

    private fun Headers.toHeaders(): ListMultimap<String, String> {
        val headers =
            MultimapBuilder.treeKeys(String.CASE_INSENSITIVE_ORDER)
                .arrayListValues()
                .build<String, String>()
        forEach { pair -> headers.put(pair.first, pair.second) }
        return headers
    }

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var baseUrl: HttpUrl? = null
        // The default timeout is 1 minute.
        private var timeout: Duration = Duration.ofSeconds(60)
        private var proxy: Proxy? = null

        fun baseUrl(baseUrl: String) = apply { this.baseUrl = baseUrl.toHttpUrl() }

        fun timeout(timeout: Duration) = apply { this.timeout = timeout }

        fun proxy(proxy: Proxy?) = apply { this.proxy = proxy }

        fun build(): OkHttpClient =
            OkHttpClient(
                okhttp3.OkHttpClient.Builder()
                    .connectTimeout(timeout)
                    .readTimeout(timeout)
                    .writeTimeout(timeout)
                    .callTimeout(if (timeout.seconds == 0L) timeout else timeout.plusSeconds(30))
                    .proxy(proxy)
                    .build(),
                checkNotNull(baseUrl) { "`baseUrl` is required but was not set" },
            )
    }
}
