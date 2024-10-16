// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AppCreateResponseTest {

    @Test
    fun createAppCreateResponse() {
        val appCreateResponse =
            AppCreateResponse.builder().applicationId("applicationId").message("message").build()
        assertThat(appCreateResponse).isNotNull
        assertThat(appCreateResponse.applicationId()).contains("applicationId")
        assertThat(appCreateResponse.message()).contains("message")
    }
}
