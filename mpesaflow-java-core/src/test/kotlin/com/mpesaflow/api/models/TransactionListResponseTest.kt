// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TransactionListResponseTest {

    @Test
    fun createTransactionListResponse() {
        val transactionListResponse =
            TransactionListResponse.builder()
                .data(
                    listOf(
                        Transaction.builder()
                            .id("id")
                            .accountReference("accountReference")
                            .amount(42.23)
                            .dateCreated(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .mpesaRequestId("mpesaRequestId")
                            .phoneNumber("phoneNumber")
                            .resultDesc("resultDesc")
                            .status(Transaction.Status.PENDING)
                            .transactionDesc("transactionDesc")
                            .transactionId("transactionId")
                            .build()
                    )
                )
                .build()
        assertThat(transactionListResponse).isNotNull
        assertThat(transactionListResponse.data().get())
            .containsExactly(
                Transaction.builder()
                    .id("id")
                    .accountReference("accountReference")
                    .amount(42.23)
                    .dateCreated(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .mpesaRequestId("mpesaRequestId")
                    .phoneNumber("phoneNumber")
                    .resultDesc("resultDesc")
                    .status(Transaction.Status.PENDING)
                    .transactionDesc("transactionDesc")
                    .transactionId("transactionId")
                    .build()
            )
    }
}
