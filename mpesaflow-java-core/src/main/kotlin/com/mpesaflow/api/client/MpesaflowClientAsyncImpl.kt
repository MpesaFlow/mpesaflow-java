// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.client

import com.mpesaflow.api.core.ClientOptions
import com.mpesaflow.api.core.http.HttpResponse.Handler
import com.mpesaflow.api.errors.MpesaflowError
import com.mpesaflow.api.models.*
import com.mpesaflow.api.services.async.*
import com.mpesaflow.api.services.errorHandler

class MpesaflowClientAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : MpesaflowClientAsync {

    private val errorHandler: Handler<MpesaflowError> = errorHandler(clientOptions.jsonMapper)

    private val sync: MpesaflowClient by lazy { MpesaflowClientImpl(clientOptions) }

    private val payments: PaymentServiceAsync by lazy { PaymentServiceAsyncImpl(clientOptions) }

    private val transactions: TransactionServiceAsync by lazy {
        TransactionServiceAsyncImpl(clientOptions)
    }

    override fun sync(): MpesaflowClient = sync

    override fun payments(): PaymentServiceAsync = payments

    override fun transactions(): TransactionServiceAsync = transactions
}
