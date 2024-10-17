// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.blocking.apps

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
import com.mpesaflow.api.models.AppApiKeyCreateParams
import com.mpesaflow.api.models.AppApiKeyCreateResponse
import com.mpesaflow.api.models.AppApiKeyDeleteParams
import com.mpesaflow.api.models.AppApiKeyDeleteResponse
import com.mpesaflow.api.models.AppApiKeyListParams
import com.mpesaflow.api.models.AppApiKeyListResponse

class ApiKeyServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : ApiKeyService {

    private val errorHandler: Handler<MpesaflowError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<AppApiKeyCreateResponse> =
        jsonHandler<AppApiKeyCreateResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Create a new API key for an application */
    override fun create(
        params: AppApiKeyCreateParams,
        requestOptions: RequestOptions
    ): AppApiKeyCreateResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("apps", params.getPathParam(0), "api-keys", "create")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<AppApiKeyListResponse> =
        jsonHandler<AppApiKeyListResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** List all API keys for an application */
    override fun list(
        params: AppApiKeyListParams,
        requestOptions: RequestOptions
    ): AppApiKeyListResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("apps", params.getPathParam(0), "api-keys", "list")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val deleteHandler: Handler<AppApiKeyDeleteResponse> =
        jsonHandler<AppApiKeyDeleteResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Delete an API key */
    override fun delete(
        params: AppApiKeyDeleteParams,
        requestOptions: RequestOptions
    ): AppApiKeyDeleteResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("apps", params.getPathParam(0), "api-keys", params.getPathParam(1))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
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
