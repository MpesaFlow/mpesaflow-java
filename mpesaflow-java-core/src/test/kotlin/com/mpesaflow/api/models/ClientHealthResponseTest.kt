// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ClientHealthResponseTest {

    @Test
    fun createClientHealthResponse() {
        val clientHealthResponse =
            ClientHealthResponse.builder().status(ClientHealthResponse.Status.HEALTHY).build()
        assertThat(clientHealthResponse).isNotNull
        assertThat(clientHealthResponse.status()).contains(ClientHealthResponse.Status.HEALTHY)
    }
}
