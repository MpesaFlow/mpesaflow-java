// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.blocking

import com.mpesaflow.api.TestServerExtension
import com.mpesaflow.api.client.okhttp.MpesaflowOkHttpClient
import com.mpesaflow.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class AppServiceTest {

    @Test
    fun callCreate() {
        val client =
            MpesaflowOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .appApiKey("My App API Key")
                .build()
        val appService = client.apps()
        val appCreateResponse =
            appService.create(
                AppCreateParams.builder().description("description").name("name").build()
            )
        println(appCreateResponse)
        appCreateResponse.validate()
    }

    @Test
    fun callList() {
        val client =
            MpesaflowOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .appApiKey("My App API Key")
                .build()
        val appService = client.apps()
        val appListResponse =
            appService.list(
                AppListParams.builder()
                    .endingBefore("ending_before")
                    .limit(123L)
                    .startingAfter("starting_after")
                    .build()
            )
        println(appListResponse)
        appListResponse.validate()
    }

    @Test
    fun callDelete() {
        val client =
            MpesaflowOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .appApiKey("My App API Key")
                .build()
        val appService = client.apps()
        val appDeleteResponse = appService.delete(AppDeleteParams.builder().appId("appId").build())
        println(appDeleteResponse)
        appDeleteResponse.validate()
    }
}
