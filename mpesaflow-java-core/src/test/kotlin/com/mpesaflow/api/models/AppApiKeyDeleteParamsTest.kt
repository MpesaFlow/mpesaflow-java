// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import com.mpesaflow.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AppApiKeyDeleteParamsTest {

    @Test
    fun createAppApiKeyDeleteParams() {
        AppApiKeyDeleteParams.builder().appId("appId").apiKeyId("apiKeyId").build()
    }

    @Test
    fun getPathParam() {
        val params = AppApiKeyDeleteParams.builder().appId("appId").apiKeyId("apiKeyId").build()
        assertThat(params).isNotNull
        // path param "appId"
        assertThat(params.getPathParam(0)).isEqualTo("appId")
        // path param "apiKeyId"
        assertThat(params.getPathParam(1)).isEqualTo("apiKeyId")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
