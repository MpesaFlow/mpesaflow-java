// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AppApiKeyListResponseTest {

    @Test
    fun createAppApiKeyListResponse() {
        val appApiKeyListResponse =
            AppApiKeyListResponse.builder()
                .data(
                    listOf(
                        AppApiKeyListResponse.Data.builder()
                            .id("id")
                            .applicationId("applicationId")
                            .keyName("keyName")
                            .build()
                    )
                )
                .build()
        assertThat(appApiKeyListResponse).isNotNull
        assertThat(appApiKeyListResponse.data().get())
            .containsExactly(
                AppApiKeyListResponse.Data.builder()
                    .id("id")
                    .applicationId("applicationId")
                    .keyName("keyName")
                    .build()
            )
    }
}
