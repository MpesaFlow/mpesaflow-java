// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.mpesaflow.api.services.blocking

import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.models.Payment
import com.mpesaflow.api.models.PaymentCreateParams

interface PaymentService {

    /** Initiate a payment */
    @JvmOverloads
    fun create(
        params: PaymentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Payment
}
