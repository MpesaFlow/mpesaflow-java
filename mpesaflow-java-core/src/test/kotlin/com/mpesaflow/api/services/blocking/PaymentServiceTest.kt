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
    fun callPaybill() {
        val client = MpesaflowOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val paymentService = client.payments()
        val paymentPaybillResponse =
            paymentService.paybill(
                PaymentPaybillParams.builder()
                    .accountReference("accountReference")
                    .amount(42.23)
                    .phoneNumber("phoneNumber")
                    .transactionDesc("transactionDesc")
                    .build()
            )
        println(paymentPaybillResponse)
        paymentPaybillResponse.validate()
    }
}
