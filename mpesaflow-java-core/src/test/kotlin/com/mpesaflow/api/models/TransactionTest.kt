// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TransactionTest {

    @Test
    fun createTransaction() {
        val transaction =
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
        assertThat(transaction).isNotNull
        assertThat(transaction.accountReference()).contains("accountReference")
        assertThat(transaction.amount()).contains(42.23)
        assertThat(transaction.dateCreated())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(transaction.mpesaRequestId()).contains("mpesaRequestId")
        assertThat(transaction.phoneNumber()).contains("phoneNumber")
        assertThat(transaction.resultDesc()).contains("resultDesc")
        assertThat(transaction.status()).contains(Transaction.Status.PENDING)
        assertThat(transaction.transactionDesc()).contains("transactionDesc")
        assertThat(transaction.transactionId()).contains("transactionId")
    }
}
