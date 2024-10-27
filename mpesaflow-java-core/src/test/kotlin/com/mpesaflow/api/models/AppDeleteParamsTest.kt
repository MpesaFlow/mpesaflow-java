// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import com.mpesaflow.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AppDeleteParamsTest {

    @Test
    fun createAppDeleteParams() {
        AppDeleteParams.builder().appId("appId").build()
    }

    @Test
    fun getPathParam() {
        val params = AppDeleteParams.builder().appId("appId").build()
        assertThat(params).isNotNull
        // path param "appId"
        assertThat(params.getPathParam(0)).isEqualTo("appId")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
