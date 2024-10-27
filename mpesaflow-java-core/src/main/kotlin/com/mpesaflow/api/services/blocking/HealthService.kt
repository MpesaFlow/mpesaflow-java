// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.mpesaflow.api.services.blocking

import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.models.HealthRetrieveParams
import com.mpesaflow.api.models.HealthRetrieveResponse

interface HealthService {

    /** Check server health */
    @JvmOverloads
    fun retrieve(
        params: HealthRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): HealthRetrieveResponse
}
