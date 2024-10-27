// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import com.mpesaflow.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TransactionListParamsTest {

    @Test
    fun createTransactionListParams() {
        TransactionListParams.builder()
            .appId("appId")
            .endingBefore("ending_before")
            .limit(123L)
            .startingAfter("starting_after")
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            TransactionListParams.builder()
                .appId("appId")
                .endingBefore("ending_before")
                .limit(123L)
                .startingAfter("starting_after")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("appId", listOf("appId"))
        expected.put("ending_before", listOf("ending_before"))
        expected.put("limit", listOf("123"))
        expected.put("starting_after", listOf("starting_after"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = TransactionListParams.builder().appId("appId").build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("appId", listOf("appId"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
