// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.client

import com.mpesaflow.api.core.ClientOptions
import com.mpesaflow.api.core.getPackageVersion
import com.mpesaflow.api.models.*
import com.mpesaflow.api.services.async.*

class MpesaflowClientAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : MpesaflowClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.containsKey("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: MpesaflowClient by lazy { MpesaflowClientImpl(clientOptions) }

    private val apps: AppServiceAsync by lazy { AppServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val transactions: TransactionServiceAsync by lazy {
        TransactionServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): MpesaflowClient = sync

    override fun apps(): AppServiceAsync = apps

    override fun transactions(): TransactionServiceAsync = transactions
}
