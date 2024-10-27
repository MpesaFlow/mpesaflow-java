// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import com.mpesaflow.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TransactionCreateParamsTest {

    @Test
    fun createTransactionCreateParams() {
        TransactionCreateParams.builder()
            .accountReference("accountReference")
            .amount(42.23)
            .mpesaRequestId("mpesaRequestId")
            .phoneNumber("phoneNumber")
            .transactionDesc("transactionDesc")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            TransactionCreateParams.builder()
                .accountReference("accountReference")
                .amount(42.23)
                .mpesaRequestId("mpesaRequestId")
                .phoneNumber("phoneNumber")
                .transactionDesc("transactionDesc")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.accountReference()).isEqualTo("accountReference")
        assertThat(body.amount()).isEqualTo(42.23)
        assertThat(body.mpesaRequestId()).isEqualTo("mpesaRequestId")
        assertThat(body.phoneNumber()).isEqualTo("phoneNumber")
        assertThat(body.transactionDesc()).isEqualTo("transactionDesc")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = TransactionCreateParams.builder().build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }
}
