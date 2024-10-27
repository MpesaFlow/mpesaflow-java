// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import com.mpesaflow.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AppApiKeyCreateParamsTest {

    @Test
    fun createAppApiKeyCreateParams() {
        AppApiKeyCreateParams.builder().appId("appId").keyName("keyName").build()
    }

    @Test
    fun getBody() {
        val params = AppApiKeyCreateParams.builder().appId("appId").keyName("keyName").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.keyName()).isEqualTo("keyName")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = AppApiKeyCreateParams.builder().appId("appId").build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
        val params = AppApiKeyCreateParams.builder().appId("appId").build()
        assertThat(params).isNotNull
        // path param "appId"
        assertThat(params.getPathParam(0)).isEqualTo("appId")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
