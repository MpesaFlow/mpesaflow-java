// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.mpesaflow.api.client

import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.models.*
import com.mpesaflow.api.services.async.*
import java.util.concurrent.CompletableFuture

interface MpesaflowClientAsync {

    fun sync(): MpesaflowClient

    fun apps(): AppServiceAsync

    fun transactions(): TransactionServiceAsync

    /** Check server health */
    @JvmOverloads
    fun health(
        params: ClientHealthParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ClientHealthResponse>
}
