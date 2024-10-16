// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.blocking

import com.mpesaflow.api.TestServerExtension
import com.mpesaflow.api.client.okhttp.MpesaflowOkHttpClient
import com.mpesaflow.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class TransactionServiceTest {

    @Test
    fun callCreate() {
        val client =
            MpesaflowOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val transactionService = client.transactions()
        val transactionCreateResponse =
            transactionService.create(
                TransactionCreateParams.builder()
                    .accountReference("accountReference")
                    .amount(42.23)
                    .mpesaRequestId("mpesaRequestId")
                    .phoneNumber("phoneNumber")
                    .transactionDesc("transactionDesc")
                    .build()
            )
        println(transactionCreateResponse)
        transactionCreateResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MpesaflowOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val transactionService = client.transactions()
        val transaction =
            transactionService.retrieve(
                TransactionRetrieveParams.builder().transactionId("transactionId").build()
            )
        println(transaction)
        transaction.validate()
    }

    @Test
    fun callList() {
        val client =
            MpesaflowOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val transactionService = client.transactions()
        val transactionListResponse =
            transactionService.list(
                TransactionListParams.builder()
                    .appId("appId")
                    .endingBefore("ending_before")
                    .limit(123L)
                    .startingAfter("starting_after")
                    .build()
            )
        println(transactionListResponse)
        transactionListResponse.validate()
    }
}
