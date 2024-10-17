// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TransactionCreateResponseTest {

    @Test
    fun createTransactionCreateResponse() {
        val transactionCreateResponse =
            TransactionCreateResponse.builder()
                .message("message")
                .transactionId("transactionId")
                .build()
        assertThat(transactionCreateResponse).isNotNull
        assertThat(transactionCreateResponse.message()).contains("message")
        assertThat(transactionCreateResponse.transactionId()).contains("transactionId")
    }
}
