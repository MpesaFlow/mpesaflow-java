// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PaymentTest {

    @Test
    fun createPayment() {
        val payment =
            Payment.builder()
                .message("message")
                .mpesaRequestId("mpesaRequestId")
                .status(Payment.Status.PENDING)
                .transactionId("transactionId")
                .build()
        assertThat(payment).isNotNull
        assertThat(payment.message()).contains("message")
        assertThat(payment.mpesaRequestId()).contains("mpesaRequestId")
        assertThat(payment.status()).contains(Payment.Status.PENDING)
        assertThat(payment.transactionId()).contains("transactionId")
    }
}
