// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import com.mpesaflow.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AppCreateParamsTest {

    @Test
    fun createAppCreateParams() {
        AppCreateParams.builder().description("description").name("name").build()
    }

    @Test
    fun getBody() {
        val params = AppCreateParams.builder().description("description").name("name").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.description()).isEqualTo("description")
        assertThat(body.name()).isEqualTo("name")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = AppCreateParams.builder().build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }
}
