// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AppListResponseTest {

    @Test
    fun createAppListResponse() {
        val appListResponse =
            AppListResponse.builder()
                .data(
                    listOf(
                        Application.builder()
                            .id("id")
                            .description("description")
                            .name("name")
                            .build()
                    )
                )
                .build()
        assertThat(appListResponse).isNotNull
        assertThat(appListResponse.data().get())
            .containsExactly(
                Application.builder().id("id").description("description").name("name").build()
            )
    }
}
