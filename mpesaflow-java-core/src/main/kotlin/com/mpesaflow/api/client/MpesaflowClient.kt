// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.client

import com.mpesaflow.api.models.*
import com.mpesaflow.api.services.blocking.*

interface MpesaflowClient {

    fun async(): MpesaflowClientAsync

    fun apps(): AppService

    fun transactions(): TransactionService

    fun health(): HealthService
}
