// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.mpesaflow.api.services.async

import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.models.PaymentPaybillParams
import com.mpesaflow.api.models.PaymentPaybillResponse
import java.util.concurrent.CompletableFuture

interface PaymentServiceAsync {

    /** Initiate a payment */
    @JvmOverloads
    fun paybill(
        params: PaymentPaybillParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<PaymentPaybillResponse>
}
