// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AppApiKeyListResponseTest {

    @Test
    fun createAppApiKeyListResponse() {
        val appApiKeyListResponse =
            AppApiKeyListResponse.builder()
                .id("id")
                .applicationId("applicationId")
                .keyName("keyName")
                .build()
        assertThat(appApiKeyListResponse).isNotNull
        assertThat(appApiKeyListResponse.id()).isEqualTo("id")
        assertThat(appApiKeyListResponse.applicationId()).contains("applicationId")
        assertThat(appApiKeyListResponse.keyName()).contains("keyName")
    }
}
