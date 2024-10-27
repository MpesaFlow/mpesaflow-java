// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.mpesaflow.api.services.async.apps

import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.models.AppApiKeyCreateParams
import com.mpesaflow.api.models.AppApiKeyCreateResponse
import com.mpesaflow.api.models.AppApiKeyDeleteParams
import com.mpesaflow.api.models.AppApiKeyDeleteResponse
import com.mpesaflow.api.models.AppApiKeyListPageAsync
import com.mpesaflow.api.models.AppApiKeyListParams
import java.util.concurrent.CompletableFuture

interface ApiKeyServiceAsync {

    /** Create a new API key for an application */
    @JvmOverloads
    fun create(
        params: AppApiKeyCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AppApiKeyCreateResponse>

    /** List all API keys for an application */
    @JvmOverloads
    fun list(
        params: AppApiKeyListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AppApiKeyListPageAsync>

    /** Delete an API key */
    @JvmOverloads
    fun delete(
        params: AppApiKeyDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AppApiKeyDeleteResponse>
}
