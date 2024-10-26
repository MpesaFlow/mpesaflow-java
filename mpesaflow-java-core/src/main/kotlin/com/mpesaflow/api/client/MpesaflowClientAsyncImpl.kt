// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.client

import com.mpesaflow.api.core.ClientOptions
import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.core.getPackageVersion
import com.mpesaflow.api.core.handlers.errorHandler
import com.mpesaflow.api.core.handlers.stringHandler
import com.mpesaflow.api.core.handlers.withErrorHandler
import com.mpesaflow.api.core.http.HttpMethod
import com.mpesaflow.api.core.http.HttpRequest
import com.mpesaflow.api.core.http.HttpResponse.Handler
import com.mpesaflow.api.errors.MpesaflowError
import com.mpesaflow.api.models.*
import com.mpesaflow.api.services.async.*
import java.util.concurrent.CompletableFuture

class MpesaflowClientAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : MpesaflowClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.containsKey("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    private val errorHandler: Handler<MpesaflowError> = errorHandler(clientOptions.jsonMapper)

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: MpesaflowClient by lazy { MpesaflowClientImpl(clientOptions) }

    private val apps: AppServiceAsync by lazy { AppServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val transactions: TransactionServiceAsync by lazy {
        TransactionServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): MpesaflowClient = sync

    override fun apps(): AppServiceAsync = apps

    override fun transactions(): TransactionServiceAsync = transactions

    private val healthHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

    /** Health check endpoint */
    override fun health(
        params: ClientHealthParams,
        requestOptions: RequestOptions
    ): CompletableFuture<String> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("health")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response.use { healthHandler.handle(it) }
        }
    }
}
