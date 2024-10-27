// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HealthRetrieveResponseTest {

    @Test
    fun createHealthRetrieveResponse() {
        val healthRetrieveResponse =
            HealthRetrieveResponse.builder().status(HealthRetrieveResponse.Status.HEALTHY).build()
        assertThat(healthRetrieveResponse).isNotNull
        assertThat(healthRetrieveResponse.status()).contains(HealthRetrieveResponse.Status.HEALTHY)
    }
}
