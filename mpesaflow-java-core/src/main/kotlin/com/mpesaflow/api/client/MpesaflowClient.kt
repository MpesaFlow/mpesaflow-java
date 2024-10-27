// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.mpesaflow.api.client

import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.models.*
import com.mpesaflow.api.services.blocking.*

interface MpesaflowClient {

    fun async(): MpesaflowClientAsync

    fun apps(): AppService

    fun transactions(): TransactionService

    /** Check server health */
    @JvmOverloads
    fun health(
        params: ClientHealthParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ClientHealthResponse
}
