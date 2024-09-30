// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.async

import com.mpesaflow.api.core.ClientOptions
import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.core.http.HttpMethod
import com.mpesaflow.api.core.http.HttpRequest
import com.mpesaflow.api.core.http.HttpResponse.Handler
import com.mpesaflow.api.errors.MpesaflowError
import com.mpesaflow.api.models.PaymentPaybillParams
import com.mpesaflow.api.models.PaymentPaybillResponse
import com.mpesaflow.api.services.errorHandler
import com.mpesaflow.api.services.json
import com.mpesaflow.api.services.jsonHandler
import com.mpesaflow.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class PaymentServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : PaymentServiceAsync {

    private val errorHandler: Handler<MpesaflowError> = errorHandler(clientOptions.jsonMapper)

    private val paybillHandler: Handler<PaymentPaybillResponse> =
        jsonHandler<PaymentPaybillResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Initiate a payment */
    override fun paybill(
        params: PaymentPaybillParams,
        requestOptions: RequestOptions
    ): CompletableFuture<PaymentPaybillResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("paybill")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { paybillHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
