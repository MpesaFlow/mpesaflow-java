// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.blocking

import com.mpesaflow.api.TestServerExtension
import com.mpesaflow.api.client.okhttp.MpesaflowOkHttpClient
import com.mpesaflow.api.models.*
import com.mpesaflow.api.models.AppListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class AppServiceTest {

    @Test
    fun callCreate() {
        val client =
            MpesaflowOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
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
                .bearerToken("My Bearer Token")
                .build()
        val appService = client.apps()
        val response = appService.list(AppListParams.builder().build())
        println(response)
        response.myData().forEach { it.validate() }
    }

    @Test
    fun callDelete() {
        val client =
            MpesaflowOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val appService = client.apps()
        val appDeleteResponse = appService.delete(AppDeleteParams.builder().appId("appId").build())
        println(appDeleteResponse)
        appDeleteResponse.validate()
    }
}
