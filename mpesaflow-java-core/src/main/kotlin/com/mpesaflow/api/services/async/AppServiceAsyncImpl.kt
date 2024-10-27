// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.async

import com.mpesaflow.api.core.ClientOptions
import com.mpesaflow.api.core.RequestOptions
import com.mpesaflow.api.core.handlers.errorHandler
import com.mpesaflow.api.core.handlers.jsonHandler
import com.mpesaflow.api.core.handlers.withErrorHandler
import com.mpesaflow.api.core.http.HttpMethod
import com.mpesaflow.api.core.http.HttpRequest
import com.mpesaflow.api.core.http.HttpResponse.Handler
import com.mpesaflow.api.core.json
import com.mpesaflow.api.errors.MpesaflowError
import com.mpesaflow.api.models.AppCreateParams
import com.mpesaflow.api.models.AppCreateResponse
import com.mpesaflow.api.models.AppDeleteParams
import com.mpesaflow.api.models.AppDeleteResponse
import com.mpesaflow.api.models.AppListPageAsync
import com.mpesaflow.api.models.AppListParams
import com.mpesaflow.api.services.async.apps.ApiKeyServiceAsync
import com.mpesaflow.api.services.async.apps.ApiKeyServiceAsyncImpl
import java.util.concurrent.CompletableFuture

class AppServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : AppServiceAsync {

    private val errorHandler: Handler<MpesaflowError> = errorHandler(clientOptions.jsonMapper)

    private val apiKeys: ApiKeyServiceAsync by lazy { ApiKeyServiceAsyncImpl(clientOptions) }

    override fun apiKeys(): ApiKeyServiceAsync = apiKeys

    private val createHandler: Handler<AppCreateResponse> =
        jsonHandler<AppCreateResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a new application */
    override fun create(
        params: AppCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<AppCreateResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("apps", "create")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<AppListPageAsync.Response> =
        jsonHandler<AppListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List all applications */
    override fun list(
        params: AppListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<AppListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("apps", "list")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { AppListPageAsync.of(this, params, it) }
        }
    }

    private val deleteHandler: Handler<AppDeleteResponse> =
        jsonHandler<AppDeleteResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Delete an application */
    override fun delete(
        params: AppDeleteParams,
        requestOptions: RequestOptions
    ): CompletableFuture<AppDeleteResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("apps", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { deleteHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
