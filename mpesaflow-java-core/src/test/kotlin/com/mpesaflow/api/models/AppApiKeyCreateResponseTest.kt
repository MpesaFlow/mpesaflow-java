// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AppApiKeyCreateResponseTest {

    @Test
    fun createAppApiKeyCreateResponse() {
        val appApiKeyCreateResponse =
            AppApiKeyCreateResponse.builder().apiKeyId("apiKeyId").message("message").build()
        assertThat(appApiKeyCreateResponse).isNotNull
        assertThat(appApiKeyCreateResponse.apiKeyId()).contains("apiKeyId")
        assertThat(appApiKeyCreateResponse.message()).contains("message")
    }
}
