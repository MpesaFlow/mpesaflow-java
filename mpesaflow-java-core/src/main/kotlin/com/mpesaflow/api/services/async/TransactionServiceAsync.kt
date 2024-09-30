// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.mpesaflow.api.services.async

import com.mpesaflow.api.services.async.transactions.StatusServiceAsync

interface TransactionServiceAsync {

    fun status(): StatusServiceAsync
}
