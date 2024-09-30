// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services.blocking.transactions

import com.mpesaflow.api.TestServerExtension
import com.mpesaflow.api.client.okhttp.MpesaflowOkHttpClient
import com.mpesaflow.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class TransactionStatusServiceTest {

    @Test
    fun callRetrieve() {
        val client = MpesaflowOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val transactionStatusService = client.transactions().transactionStatus()
        val transactionStatus =
            transactionStatusService.retrieve(
                TransactionTransactionStatusRetrieveParams.builder()
                    .transactionId("transactionId")
                    .build()
            )
        println(transactionStatus)
        transactionStatus.validate()
    }
}
