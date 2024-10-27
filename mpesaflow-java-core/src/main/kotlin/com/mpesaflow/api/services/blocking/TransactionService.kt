// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.mpesaflow.api.services.blocking

import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.models.Transaction
import com.mpesaflow.api.models.TransactionCreateParams
import com.mpesaflow.api.models.TransactionCreateResponse
import com.mpesaflow.api.models.TransactionListPage
import com.mpesaflow.api.models.TransactionListParams
import com.mpesaflow.api.models.TransactionRetrieveParams

interface TransactionService {

    /** Create a new transaction */
    @JvmOverloads
    fun create(
        params: TransactionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TransactionCreateResponse

    /** Get transaction details */
    @JvmOverloads
    fun retrieve(
        params: TransactionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Transaction

    /** List all transactions */
    @JvmOverloads
    fun list(
        params: TransactionListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TransactionListPage
}
