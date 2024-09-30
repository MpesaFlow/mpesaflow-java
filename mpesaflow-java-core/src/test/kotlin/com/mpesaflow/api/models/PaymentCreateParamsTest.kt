// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import com.mpesaflow.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PaymentCreateParamsTest {

    @Test
    fun createPaymentCreateParams() {
        PaymentCreateParams.builder()
            .accountReference("accountReference")
            .amount(42.23)
            .phoneNumber("phoneNumber")
            .transactionDesc("transactionDesc")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            PaymentCreateParams.builder()
                .accountReference("accountReference")
                .amount(42.23)
                .phoneNumber("phoneNumber")
                .transactionDesc("transactionDesc")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.accountReference()).isEqualTo("accountReference")
        assertThat(body.amount()).isEqualTo(42.23)
        assertThat(body.phoneNumber()).isEqualTo("phoneNumber")
        assertThat(body.transactionDesc()).isEqualTo("transactionDesc")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            PaymentCreateParams.builder()
                .accountReference("accountReference")
                .amount(42.23)
                .phoneNumber("phoneNumber")
                .transactionDesc("transactionDesc")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.accountReference()).isEqualTo("accountReference")
        assertThat(body.amount()).isEqualTo(42.23)
        assertThat(body.phoneNumber()).isEqualTo("phoneNumber")
        assertThat(body.transactionDesc()).isEqualTo("transactionDesc")
    }
}
