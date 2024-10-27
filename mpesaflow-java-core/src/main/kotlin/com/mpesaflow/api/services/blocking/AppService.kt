// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.mpesaflow.api.services.blocking

import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.models.AppCreateParams
import com.mpesaflow.api.models.AppCreateResponse
import com.mpesaflow.api.models.AppDeleteParams
import com.mpesaflow.api.models.AppDeleteResponse
import com.mpesaflow.api.models.AppListPage
import com.mpesaflow.api.models.AppListParams
import com.mpesaflow.api.services.blocking.apps.ApiKeyService

interface AppService {

    fun apiKeys(): ApiKeyService

    /** Create a new application */
    @JvmOverloads
    fun create(
        params: AppCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AppCreateResponse

    /** List all applications */
    @JvmOverloads
    fun list(
        params: AppListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AppListPage

    /** Delete an application */
    @JvmOverloads
    fun delete(
        params: AppDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AppDeleteResponse
}
