// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.async.transactions

import com.mpesaflow.api.core.ClientOptions
import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.core.http.HttpMethod
import com.mpesaflow.api.core.http.HttpRequest
import com.mpesaflow.api.core.http.HttpResponse.Handler
import com.mpesaflow.api.errors.MpesaflowError
import com.mpesaflow.api.models.TransactionStatus
import com.mpesaflow.api.models.TransactionTransactionStatusRetrieveParams
import com.mpesaflow.api.services.errorHandler
import com.mpesaflow.api.services.jsonHandler
import com.mpesaflow.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class TransactionStatusServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : TransactionStatusServiceAsync {

    private val errorHandler: Handler<MpesaflowError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<TransactionStatus> =
        jsonHandler<TransactionStatus>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Get transaction status */
    override fun retrieve(
        params: TransactionTransactionStatusRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TransactionStatus> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("transaction-status", params.getPathParam(0))
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
}
