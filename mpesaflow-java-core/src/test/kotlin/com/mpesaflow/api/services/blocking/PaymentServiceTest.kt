// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.blocking

import com.mpesaflow.api.TestServerExtension
import com.mpesaflow.api.client.okhttp.MpesaflowOkHttpClient
import com.mpesaflow.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class PaymentServiceTest {

    @Test
    fun callCreate() {
        val client =
            MpesaflowOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val paymentService = client.payments()
        val payment =
            paymentService.create(
                PaymentCreateParams.builder()
                    .accountReference("accountReference")
                    .amount(42.23)
                    .phoneNumber("phoneNumber")
                    .transactionDesc("transactionDesc")
                    .build()
            )
        println(payment)
        payment.validate()
    }
}
