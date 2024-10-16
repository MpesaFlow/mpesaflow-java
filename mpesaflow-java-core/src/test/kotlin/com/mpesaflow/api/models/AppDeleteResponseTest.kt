// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AppDeleteResponseTest {

    @Test
    fun createAppDeleteResponse() {
        val appDeleteResponse = AppDeleteResponse.builder().message("message").build()
        assertThat(appDeleteResponse).isNotNull
        assertThat(appDeleteResponse.message()).contains("message")
    }
}
