// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.client

import com.mpesaflow.api.models.*
import com.mpesaflow.api.services.async.*

interface MpesaflowClientAsync {

    fun sync(): MpesaflowClient

    fun apps(): AppServiceAsync

    fun transactions(): TransactionServiceAsync
}
