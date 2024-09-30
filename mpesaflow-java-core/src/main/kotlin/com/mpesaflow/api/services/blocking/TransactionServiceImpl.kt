// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.blocking

import com.mpesaflow.api.core.ClientOptions
import com.mpesaflow.api.core.http.HttpResponse.Handler
import com.mpesaflow.api.errors.MpesaflowError
import com.mpesaflow.api.services.blocking.transactions.TransactionStatusService
import com.mpesaflow.api.services.blocking.transactions.TransactionStatusServiceImpl
import com.mpesaflow.api.services.errorHandler

class TransactionServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : TransactionService {

    private val errorHandler: Handler<MpesaflowError> = errorHandler(clientOptions.jsonMapper)

    private val transactionStatus: TransactionStatusService by lazy {
        TransactionStatusServiceImpl(clientOptions)
    }

    override fun transactionStatus(): TransactionStatusService = transactionStatus
}
