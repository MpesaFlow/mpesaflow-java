// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest {

    @Test
    fun createApplication() {
        val application =
            Application.builder().id("id").description("description").name("name").build()
        assertThat(application).isNotNull
        assertThat(application.id()).contains("id")
        assertThat(application.description()).contains("description")
        assertThat(application.name()).contains("name")
    }
}
