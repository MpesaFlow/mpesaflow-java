// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AppApiKeyDeleteResponseTest {

    @Test
    fun createAppApiKeyDeleteResponse() {
        val appApiKeyDeleteResponse = AppApiKeyDeleteResponse.builder().message("message").build()
        assertThat(appApiKeyDeleteResponse).isNotNull
        assertThat(appApiKeyDeleteResponse.message()).contains("message")
    }
}
