// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.mpesaflow.api.client

import com.mpesaflow.api.models.*
import com.mpesaflow.api.services.async.*

interface MpesaflowClientAsync {

    fun sync(): MpesaflowClient

    fun payments(): PaymentServiceAsync

    fun transactions(): TransactionServiceAsync
}
