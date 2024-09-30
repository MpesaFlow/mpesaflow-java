// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.async

import com.mpesaflow.api.core.ClientOptions
import com.mpesaflow.api.core.http.HttpResponse.Handler
import com.mpesaflow.api.errors.MpesaflowError
import com.mpesaflow.api.services.async.transactions.TransactionStatusServiceAsync
import com.mpesaflow.api.services.async.transactions.TransactionStatusServiceAsyncImpl
import com.mpesaflow.api.services.errorHandler

class TransactionServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : TransactionServiceAsync {

    private val errorHandler: Handler<MpesaflowError> = errorHandler(clientOptions.jsonMapper)

    private val transactionStatus: TransactionStatusServiceAsync by lazy {
        TransactionStatusServiceAsyncImpl(clientOptions)
    }

    override fun transactionStatus(): TransactionStatusServiceAsync = transactionStatus
}
