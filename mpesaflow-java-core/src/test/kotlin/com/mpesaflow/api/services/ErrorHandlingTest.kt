// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.google.common.collect.ImmutableListMultimap
import com.google.common.collect.ListMultimap
import com.mpesaflow.api.client.MpesaflowClient
import com.mpesaflow.api.client.okhttp.MpesaflowOkHttpClient
import com.mpesaflow.api.core.JsonString
import com.mpesaflow.api.core.jsonMapper
import com.mpesaflow.api.errors.BadRequestException
import com.mpesaflow.api.errors.InternalServerException
import com.mpesaflow.api.errors.MpesaflowError
import com.mpesaflow.api.errors.MpesaflowException
import com.mpesaflow.api.errors.NotFoundException
import com.mpesaflow.api.errors.PermissionDeniedException
import com.mpesaflow.api.errors.RateLimitException
import com.mpesaflow.api.errors.UnauthorizedException
import com.mpesaflow.api.errors.UnexpectedStatusCodeException
import com.mpesaflow.api.errors.UnprocessableEntityException
import com.mpesaflow.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.InstanceOfAssertFactories
import org.assertj.guava.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@WireMockTest
class ErrorHandlingTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private val MPESAFLOW_ERROR: MpesaflowError =
        MpesaflowError.builder().putAdditionalProperty("key", JsonString.of("value")).build()

    private lateinit var client: MpesaflowClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            MpesaflowOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .appApiKey("My App API Key")
                .rootApiKey("My Root API Key")
                .build()
    }

    @Test
    fun transactionsCreate200() {
        val params =
            TransactionCreateParams.builder()
                .accountReference("accountReference")
                .amount(42.23)
                .mpesaRequestId("mpesaRequestId")
                .phoneNumber("phoneNumber")
                .transactionDesc("transactionDesc")
                .build()

        val expected =
            TransactionCreateResponse.builder()
                .message("message")
                .transactionId("transactionId")
                .build()

        stubFor(post(anyUrl()).willReturn(ok().withBody(toJson(expected))))

        assertThat(client.transactions().create(params)).isEqualTo(expected)
    }

    @Test
    fun transactionsCreate400() {
        val params =
            TransactionCreateParams.builder()
                .accountReference("accountReference")
                .amount(42.23)
                .mpesaRequestId("mpesaRequestId")
                .phoneNumber("phoneNumber")
                .transactionDesc("transactionDesc")
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(400).withHeader("Foo", "Bar").withBody(toJson(MPESAFLOW_ERROR)))
        )

        assertThatThrownBy({ client.transactions().create(params) })
            .satisfies({ e ->
                assertBadRequest(e, ImmutableListMultimap.of("Foo", "Bar"), MPESAFLOW_ERROR)
            })
    }

    @Test
    fun transactionsCreate401() {
        val params =
            TransactionCreateParams.builder()
                .accountReference("accountReference")
                .amount(42.23)
                .mpesaRequestId("mpesaRequestId")
                .phoneNumber("phoneNumber")
                .transactionDesc("transactionDesc")
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(401).withHeader("Foo", "Bar").withBody(toJson(MPESAFLOW_ERROR)))
        )

        assertThatThrownBy({ client.transactions().create(params) })
            .satisfies({ e ->
                assertUnauthorized(e, ImmutableListMultimap.of("Foo", "Bar"), MPESAFLOW_ERROR)
            })
    }

    @Test
    fun transactionsCreate403() {
        val params =
            TransactionCreateParams.builder()
                .accountReference("accountReference")
                .amount(42.23)
                .mpesaRequestId("mpesaRequestId")
                .phoneNumber("phoneNumber")
                .transactionDesc("transactionDesc")
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(403).withHeader("Foo", "Bar").withBody(toJson(MPESAFLOW_ERROR)))
        )

        assertThatThrownBy({ client.transactions().create(params) })
            .satisfies({ e ->
                assertPermissionDenied(e, ImmutableListMultimap.of("Foo", "Bar"), MPESAFLOW_ERROR)
            })
    }

    @Test
    fun transactionsCreate404() {
        val params =
            TransactionCreateParams.builder()
                .accountReference("accountReference")
                .amount(42.23)
                .mpesaRequestId("mpesaRequestId")
                .phoneNumber("phoneNumber")
                .transactionDesc("transactionDesc")
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(404).withHeader("Foo", "Bar").withBody(toJson(MPESAFLOW_ERROR)))
        )

        assertThatThrownBy({ client.transactions().create(params) })
            .satisfies({ e ->
                assertNotFound(e, ImmutableListMultimap.of("Foo", "Bar"), MPESAFLOW_ERROR)
            })
    }

    @Test
    fun transactionsCreate422() {
        val params =
            TransactionCreateParams.builder()
                .accountReference("accountReference")
                .amount(42.23)
                .mpesaRequestId("mpesaRequestId")
                .phoneNumber("phoneNumber")
                .transactionDesc("transactionDesc")
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(422).withHeader("Foo", "Bar").withBody(toJson(MPESAFLOW_ERROR)))
        )

        assertThatThrownBy({ client.transactions().create(params) })
            .satisfies({ e ->
                assertUnprocessableEntity(
                    e,
                    ImmutableListMultimap.of("Foo", "Bar"),
                    MPESAFLOW_ERROR
                )
            })
    }

    @Test
    fun transactionsCreate429() {
        val params =
            TransactionCreateParams.builder()
                .accountReference("accountReference")
                .amount(42.23)
                .mpesaRequestId("mpesaRequestId")
                .phoneNumber("phoneNumber")
                .transactionDesc("transactionDesc")
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(429).withHeader("Foo", "Bar").withBody(toJson(MPESAFLOW_ERROR)))
        )

        assertThatThrownBy({ client.transactions().create(params) })
            .satisfies({ e ->
                assertRateLimit(e, ImmutableListMultimap.of("Foo", "Bar"), MPESAFLOW_ERROR)
            })
    }

    @Test
    fun transactionsCreate500() {
        val params =
            TransactionCreateParams.builder()
                .accountReference("accountReference")
                .amount(42.23)
                .mpesaRequestId("mpesaRequestId")
                .phoneNumber("phoneNumber")
                .transactionDesc("transactionDesc")
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(500).withHeader("Foo", "Bar").withBody(toJson(MPESAFLOW_ERROR)))
        )

        assertThatThrownBy({ client.transactions().create(params) })
            .satisfies({ e ->
                assertInternalServer(e, ImmutableListMultimap.of("Foo", "Bar"), MPESAFLOW_ERROR)
            })
    }

    @Test
    fun unexpectedStatusCode() {
        val params =
            TransactionCreateParams.builder()
                .accountReference("accountReference")
                .amount(42.23)
                .mpesaRequestId("mpesaRequestId")
                .phoneNumber("phoneNumber")
                .transactionDesc("transactionDesc")
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(999).withHeader("Foo", "Bar").withBody(toJson(MPESAFLOW_ERROR)))
        )

        assertThatThrownBy({ client.transactions().create(params) })
            .satisfies({ e ->
                assertUnexpectedStatusCodeException(
                    e,
                    999,
                    ImmutableListMultimap.of("Foo", "Bar"),
                    toJson(MPESAFLOW_ERROR)
                )
            })
    }

    @Test
    fun invalidBody() {
        val params =
            TransactionCreateParams.builder()
                .accountReference("accountReference")
                .amount(42.23)
                .mpesaRequestId("mpesaRequestId")
                .phoneNumber("phoneNumber")
                .transactionDesc("transactionDesc")
                .build()

        stubFor(post(anyUrl()).willReturn(status(200).withBody("Not JSON")))

        assertThatThrownBy({ client.transactions().create(params) })
            .satisfies({ e ->
                assertThat(e)
                    .isInstanceOf(MpesaflowException::class.java)
                    .hasMessage("Error reading response")
            })
    }

    @Test
    fun invalidErrorBody() {
        val params =
            TransactionCreateParams.builder()
                .accountReference("accountReference")
                .amount(42.23)
                .mpesaRequestId("mpesaRequestId")
                .phoneNumber("phoneNumber")
                .transactionDesc("transactionDesc")
                .build()

        stubFor(post(anyUrl()).willReturn(status(400).withBody("Not JSON")))

        assertThatThrownBy({ client.transactions().create(params) })
            .satisfies({ e ->
                assertBadRequest(e, ImmutableListMultimap.of(), MpesaflowError.builder().build())
            })
    }

    private fun <T> toJson(body: T): ByteArray {
        return JSON_MAPPER.writeValueAsBytes(body)
    }

    private fun assertUnexpectedStatusCodeException(
        throwable: Throwable,
        statusCode: Int,
        headers: ListMultimap<String, String>,
        responseBody: ByteArray
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnexpectedStatusCodeException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(statusCode)
                assertThat(e.body()).isEqualTo(String(responseBody))
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertBadRequest(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MpesaflowError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(BadRequestException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(400)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertUnauthorized(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MpesaflowError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(UnauthorizedException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(401)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertPermissionDenied(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MpesaflowError
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(PermissionDeniedException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(403)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertNotFound(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MpesaflowError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(NotFoundException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(404)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertUnprocessableEntity(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MpesaflowError
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnprocessableEntityException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(422)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertRateLimit(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MpesaflowError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(RateLimitException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(429)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertInternalServer(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MpesaflowError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(InternalServerException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(500)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }
}
