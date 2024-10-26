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
import com.mpesaflow.api.services.blocking.*

class MpesaflowClientImpl
constructor(
    private val clientOptions: ClientOptions,
) : MpesaflowClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.containsKey("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    private val errorHandler: Handler<MpesaflowError> = errorHandler(clientOptions.jsonMapper)

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: MpesaflowClientAsync by lazy { MpesaflowClientAsyncImpl(clientOptions) }

    private val apps: AppService by lazy { AppServiceImpl(clientOptionsWithUserAgent) }

    private val transactions: TransactionService by lazy {
        TransactionServiceImpl(clientOptionsWithUserAgent)
    }

    override fun async(): MpesaflowClientAsync = async

    override fun apps(): AppService = apps

    override fun transactions(): TransactionService = transactions

    private val healthHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

    /** Health check endpoint */
    override fun health(params: ClientHealthParams, requestOptions: RequestOptions): String {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("health")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response.use { healthHandler.handle(it) }
        }
    }
}
