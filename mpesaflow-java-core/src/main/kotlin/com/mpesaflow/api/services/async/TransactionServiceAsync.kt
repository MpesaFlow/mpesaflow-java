// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.mpesaflow.api.services.async

import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.models.TransactionRetrieveStatusParams
import com.mpesaflow.api.models.TransactionStatus
import java.util.concurrent.CompletableFuture

interface TransactionServiceAsync {

    /** Get transaction status */
    @JvmOverloads
    fun retrieveStatus(
        params: TransactionRetrieveStatusParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TransactionStatus>
}
