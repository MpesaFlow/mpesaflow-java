// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.mpesaflow.api.services.async

import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.models.AppCreateParams
import com.mpesaflow.api.models.AppCreateResponse
import com.mpesaflow.api.models.AppDeleteParams
import com.mpesaflow.api.models.AppDeleteResponse
import com.mpesaflow.api.models.AppListParams
import com.mpesaflow.api.models.AppListResponse
import com.mpesaflow.api.services.async.apps.ApiKeyServiceAsync
import java.util.concurrent.CompletableFuture

interface AppServiceAsync {

    fun apiKeys(): ApiKeyServiceAsync

    /** Create a new application */
    @JvmOverloads
    fun create(
        params: AppCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AppCreateResponse>

    /** List all applications */
    @JvmOverloads
    fun list(
        params: AppListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AppListResponse>

    /** Delete an application */
    @JvmOverloads
    fun delete(
        params: AppDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AppDeleteResponse>
}
