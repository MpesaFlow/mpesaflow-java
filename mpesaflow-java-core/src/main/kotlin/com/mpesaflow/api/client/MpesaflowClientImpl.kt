// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.client

import com.mpesaflow.api.core.ClientOptions
import com.mpesaflow.api.core.getPackageVersion
import com.mpesaflow.api.models.*
import com.mpesaflow.api.services.blocking.*

class MpesaflowClientImpl
constructor(
    private val clientOptions: ClientOptions,
) : MpesaflowClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.containsKey("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: MpesaflowClientAsync by lazy { MpesaflowClientAsyncImpl(clientOptions) }

    private val apps: AppService by lazy { AppServiceImpl(clientOptionsWithUserAgent) }

    private val transactions: TransactionService by lazy {
        TransactionServiceImpl(clientOptionsWithUserAgent)
    }

    private val health: HealthService by lazy { HealthServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): MpesaflowClientAsync = async

    override fun apps(): AppService = apps

    override fun transactions(): TransactionService = transactions

    override fun health(): HealthService = health
}
