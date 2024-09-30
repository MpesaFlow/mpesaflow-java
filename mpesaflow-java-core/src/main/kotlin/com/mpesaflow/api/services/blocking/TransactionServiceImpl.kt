// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.blocking

import com.mpesaflow.api.core.ClientOptions
import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.core.http.HttpMethod
import com.mpesaflow.api.core.http.HttpRequest
import com.mpesaflow.api.core.http.HttpResponse.Handler
import com.mpesaflow.api.errors.MpesaflowError
import com.mpesaflow.api.models.TransactionRetrieveStatusParams
import com.mpesaflow.api.models.TransactionStatus
import com.mpesaflow.api.services.errorHandler
import com.mpesaflow.api.services.jsonHandler
import com.mpesaflow.api.services.withErrorHandler

class TransactionServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : TransactionService {

    private val errorHandler: Handler<MpesaflowError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveStatusHandler: Handler<TransactionStatus> =
        jsonHandler<TransactionStatus>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Get transaction status */
    override fun retrieveStatus(
        params: TransactionRetrieveStatusParams,
        requestOptions: RequestOptions
    ): TransactionStatus {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("transaction-status", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { retrieveStatusHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
