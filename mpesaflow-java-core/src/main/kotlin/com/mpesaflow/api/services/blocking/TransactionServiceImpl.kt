// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.blocking

import com.mpesaflow.api.core.ClientOptions
import com.mpesaflow.api.core.http.HttpResponse.Handler
import com.mpesaflow.api.errors.MpesaflowError
import com.mpesaflow.api.services.blocking.transactions.StatusService
import com.mpesaflow.api.services.blocking.transactions.StatusServiceImpl
import com.mpesaflow.api.services.errorHandler

class TransactionServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : TransactionService {

    private val errorHandler: Handler<MpesaflowError> = errorHandler(clientOptions.jsonMapper)

    private val status: StatusService by lazy { StatusServiceImpl(clientOptions) }

    override fun status(): StatusService = status
}
