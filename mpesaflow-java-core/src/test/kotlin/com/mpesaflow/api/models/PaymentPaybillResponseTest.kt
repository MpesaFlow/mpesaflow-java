// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PaymentPaybillResponseTest {

    @Test
    fun createPaymentPaybillResponse() {
        val paymentPaybillResponse =
            PaymentPaybillResponse.builder()
                .message("message")
                .mpesaRequestId("mpesaRequestId")
                .status(PaymentPaybillResponse.Status.PENDING)
                .transactionId("transactionId")
                .build()
        assertThat(paymentPaybillResponse).isNotNull
        assertThat(paymentPaybillResponse.message()).contains("message")
        assertThat(paymentPaybillResponse.mpesaRequestId()).contains("mpesaRequestId")
        assertThat(paymentPaybillResponse.status()).contains(PaymentPaybillResponse.Status.PENDING)
        assertThat(paymentPaybillResponse.transactionId()).contains("transactionId")
    }
}
