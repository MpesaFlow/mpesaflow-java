// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.blocking

import com.mpesaflow.api.TestServerExtension
import com.mpesaflow.api.client.okhttp.MpesaflowOkHttpClient
import com.mpesaflow.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class HealthServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MpesaflowOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .appApiKey("My App API Key")
                .build()
        val healthService = client.health()
        val healthRetrieveResponse = healthService.retrieve(HealthRetrieveParams.builder().build())
        println(healthRetrieveResponse)
        healthRetrieveResponse.validate()
    }
}
