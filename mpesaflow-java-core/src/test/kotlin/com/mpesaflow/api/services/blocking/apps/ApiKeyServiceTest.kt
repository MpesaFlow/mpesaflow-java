// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.blocking.apps

import com.mpesaflow.api.TestServerExtension
import com.mpesaflow.api.client.okhttp.MpesaflowOkHttpClient
import com.mpesaflow.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ApiKeyServiceTest {

    @Test
    fun callCreate() {
        val client =
            MpesaflowOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val apiKeyService = client.apps().apiKeys()
        val appApiKeyCreateResponse =
            apiKeyService.create(
                AppApiKeyCreateParams.builder().appId("appId").keyName("keyName").build()
            )
        println(appApiKeyCreateResponse)
        appApiKeyCreateResponse.validate()
    }

    @Test
    fun callList() {
        val client =
            MpesaflowOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val apiKeyService = client.apps().apiKeys()
        val appApiKeyListResponse =
            apiKeyService.list(
                AppApiKeyListParams.builder()
                    .appId("appId")
                    .endingBefore("ending_before")
                    .limit(123L)
                    .startingAfter("starting_after")
                    .build()
            )
        println(appApiKeyListResponse)
        appApiKeyListResponse.validate()
    }

    @Test
    fun callDelete() {
        val client =
            MpesaflowOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val apiKeyService = client.apps().apiKeys()
        val appApiKeyDeleteResponse =
            apiKeyService.delete(
                AppApiKeyDeleteParams.builder().appId("appId").apiKeyId("apiKeyId").build()
            )
        println(appApiKeyDeleteResponse)
        appApiKeyDeleteResponse.validate()
    }
}
