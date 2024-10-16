// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.mpesaflow.api.core.ExcludeMissing
import com.mpesaflow.api.core.JsonField
import com.mpesaflow.api.core.JsonMissing
import com.mpesaflow.api.core.JsonValue
import com.mpesaflow.api.core.NoAutoDetect
import com.mpesaflow.api.core.toUnmodifiable
import com.mpesaflow.api.services.blocking.apps.ApiKeyService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport

class AppApiKeyListPage
private constructor(
    private val apiKeysService: ApiKeyService,
    private val params: AppApiKeyListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun myData(): List<AppApiKeyListResponse> = response().myData()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AppApiKeyListPage && this.apiKeysService == other.apiKeysService && this.params == other.params && this.response == other.response /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(apiKeysService, params, response) /* spotless:on */
    }

    override fun toString() =
        "AppApiKeyListPage{apiKeysService=$apiKeysService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        return !myData().isEmpty()
    }

    fun getNextPageParams(): Optional<AppApiKeyListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return if (params.endingBefore().isPresent) {
            Optional.of(
                AppApiKeyListParams.builder()
                    .from(params)
                    .endingBefore(myData().first().id())
                    .build()
            )
        } else {
            Optional.of(
                AppApiKeyListParams.builder()
                    .from(params)
                    .startingAfter(myData().last().id())
                    .build()
            )
        }
    }

    fun getNextPage(): Optional<AppApiKeyListPage> {
        return getNextPageParams().map { apiKeysService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(apiKeysService: ApiKeyService, params: AppApiKeyListParams, response: Response) =
            AppApiKeyListPage(
                apiKeysService,
                params,
                response,
            )
    }

    @JsonDeserialize(builder = Response.Builder::class)
    @NoAutoDetect
    class Response
    constructor(
        private val myData: JsonField<List<AppApiKeyListResponse>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        fun myData(): List<AppApiKeyListResponse> = myData.getNullable("my_data") ?: listOf()

        @JsonProperty("my_data")
        fun _myData(): Optional<JsonField<List<AppApiKeyListResponse>>> =
            Optional.ofNullable(myData)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Response = apply {
            if (!validated) {
                myData().map { it.validate() }
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Response && this.myData == other.myData && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        override fun hashCode(): Int {
            return /* spotless:off */ Objects.hash(myData, additionalProperties) /* spotless:on */
        }

        override fun toString() =
            "AppApiKeyListPage.Response{myData=$myData, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var myData: JsonField<List<AppApiKeyListResponse>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.myData = page.myData
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun myData(myData: List<AppApiKeyListResponse>) = myData(JsonField.of(myData))

            @JsonProperty("my_data")
            fun myData(myData: JsonField<List<AppApiKeyListResponse>>) = apply {
                this.myData = myData
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(myData, additionalProperties.toUnmodifiable())
        }
    }

    class AutoPager
    constructor(
        private val firstPage: AppApiKeyListPage,
    ) : Iterable<AppApiKeyListResponse> {

        override fun iterator(): Iterator<AppApiKeyListResponse> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.myData().size) {
                    yield(page.myData()[index++])
                }
                page = page.getNextPage().orElse(null) ?: break
                index = 0
            }
        }

        fun stream(): Stream<AppApiKeyListResponse> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
