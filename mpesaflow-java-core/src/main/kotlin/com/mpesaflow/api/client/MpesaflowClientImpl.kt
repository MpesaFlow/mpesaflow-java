// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.client

import com.mpesaflow.api.core.ClientOptions
import com.mpesaflow.api.core.http.HttpResponse.Handler
import com.mpesaflow.api.errors.MpesaflowError
import com.mpesaflow.api.models.*
import com.mpesaflow.api.services.blocking.*
import com.mpesaflow.api.services.errorHandler

class MpesaflowClientImpl
constructor(
    private val clientOptions: ClientOptions,
) : MpesaflowClient {

    private val errorHandler: Handler<MpesaflowError> = errorHandler(clientOptions.jsonMapper)

    private val async: MpesaflowClientAsync by lazy { MpesaflowClientAsyncImpl(clientOptions) }

    private val payments: PaymentService by lazy { PaymentServiceImpl(clientOptions) }

    private val transactions: TransactionService by lazy { TransactionServiceImpl(clientOptions) }

    override fun async(): MpesaflowClientAsync = async

    override fun payments(): PaymentService = payments

    override fun transactions(): TransactionService = transactions
}
