// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import com.mpesaflow.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AppApiKeyListParamsTest {

    @Test
    fun createAppApiKeyListParams() {
        AppApiKeyListParams.builder()
            .appId("appId")
            .endingBefore("ending_before")
            .limit(123L)
            .startingAfter("starting_after")
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            AppApiKeyListParams.builder()
                .appId("appId")
                .endingBefore("ending_before")
                .limit(123L)
                .startingAfter("starting_after")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("ending_before", listOf("ending_before"))
        expected.put("limit", listOf("123"))
        expected.put("starting_after", listOf("starting_after"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = AppApiKeyListParams.builder().appId("appId").build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
        val params = AppApiKeyListParams.builder().appId("appId").build()
        assertThat(params).isNotNull
        // path param "appId"
        assertThat(params.getPathParam(0)).isEqualTo("appId")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
