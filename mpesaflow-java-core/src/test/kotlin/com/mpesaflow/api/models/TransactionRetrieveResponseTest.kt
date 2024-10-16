// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TransactionRetrieveResponseTest {

    @Test
    fun createTransactionRetrieveResponse() {
        val transactionRetrieveResponse =
            TransactionRetrieveResponse.builder()
                .transaction(
                    Transaction.builder()
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
                .build()
        assertThat(transactionRetrieveResponse).isNotNull
        assertThat(transactionRetrieveResponse.transaction())
            .contains(
                Transaction.builder()
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
