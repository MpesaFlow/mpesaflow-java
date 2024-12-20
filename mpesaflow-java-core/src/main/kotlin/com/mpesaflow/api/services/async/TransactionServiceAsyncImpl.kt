// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.async

import com.mpesaflow.api.core.ClientOptions
import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.core.handlers.errorHandler
import com.mpesaflow.api.core.handlers.jsonHandler
import com.mpesaflow.api.core.handlers.withErrorHandler
import com.mpesaflow.api.core.http.HttpMethod
import com.mpesaflow.api.core.http.HttpRequest
import com.mpesaflow.api.core.http.HttpResponse.Handler
import com.mpesaflow.api.core.json
import com.mpesaflow.api.errors.MpesaflowError
import com.mpesaflow.api.models.Transaction
import com.mpesaflow.api.models.TransactionCreateParams
import com.mpesaflow.api.models.TransactionCreateResponse
import com.mpesaflow.api.models.TransactionListPageAsync
import com.mpesaflow.api.models.TransactionListParams
import com.mpesaflow.api.models.TransactionRetrieveParams
import java.util.concurrent.CompletableFuture

class TransactionServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : TransactionServiceAsync {

    private val errorHandler: Handler<MpesaflowError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<TransactionCreateResponse> =
        jsonHandler<TransactionCreateResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Create a new transaction */
    override fun create(
        params: TransactionCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TransactionCreateResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("transactions", "create")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val retrieveHandler: Handler<Transaction> =
        jsonHandler<Transaction>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Get transaction details */
    override fun retrieve(
        params: TransactionRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Transaction> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("transactions", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<TransactionListPageAsync.Response> =
        jsonHandler<TransactionListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List all transactions */
    override fun list(
        params: TransactionListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TransactionListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("transactions", "list")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { TransactionListPageAsync.of(this, params, it) }
        }
    }
}
