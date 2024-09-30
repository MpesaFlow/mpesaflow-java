// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.async

import com.mpesaflow.api.core.ClientOptions
import com.mpesaflow.api.core.http.HttpResponse.Handler
import com.mpesaflow.api.errors.MpesaflowError
import com.mpesaflow.api.services.async.transactions.StatusServiceAsync
import com.mpesaflow.api.services.async.transactions.StatusServiceAsyncImpl
import com.mpesaflow.api.services.errorHandler

class TransactionServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : TransactionServiceAsync {

    private val errorHandler: Handler<MpesaflowError> = errorHandler(clientOptions.jsonMapper)

    private val status: StatusServiceAsync by lazy { StatusServiceAsyncImpl(clientOptions) }

    override fun status(): StatusServiceAsync = status
}
