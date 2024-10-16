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
import com.mpesaflow.api.services.async.AppServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate

class AppListPageAsync
private constructor(
    private val appsService: AppServiceAsync,
    private val params: AppListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun myData(): List<Application> = response().myData()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AppListPageAsync && this.appsService == other.appsService && this.params == other.params && this.response == other.response /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(appsService, params, response) /* spotless:on */
    }

    override fun toString() =
        "AppListPageAsync{appsService=$appsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        return !myData().isEmpty()
    }

    fun getNextPageParams(): Optional<AppListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return if (params.endingBefore().isPresent) {
            Optional.of(
                AppListParams.builder().from(params).endingBefore(myData().first().id()).build()
            )
        } else {
            Optional.of(
                AppListParams.builder().from(params).startingAfter(myData().last().id()).build()
            )
        }
    }

    fun getNextPage(): CompletableFuture<Optional<AppListPageAsync>> {
        return getNextPageParams()
            .map { appsService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(appsService: AppServiceAsync, params: AppListParams, response: Response) =
            AppListPageAsync(
                appsService,
                params,
                response,
            )
    }

    @JsonDeserialize(builder = Response.Builder::class)
    @NoAutoDetect
    class Response
    constructor(
        private val myData: JsonField<List<Application>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        fun myData(): List<Application> = myData.getNullable("my_data") ?: listOf()

        @JsonProperty("my_data")
        fun _myData(): Optional<JsonField<List<Application>>> = Optional.ofNullable(myData)

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
            "AppListPageAsync.Response{myData=$myData, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var myData: JsonField<List<Application>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.myData = page.myData
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun myData(myData: List<Application>) = myData(JsonField.of(myData))

            @JsonProperty("my_data")
            fun myData(myData: JsonField<List<Application>>) = apply { this.myData = myData }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(myData, additionalProperties.toUnmodifiable())
        }
    }

    class AutoPager
    constructor(
        private val firstPage: AppListPageAsync,
    ) {

        fun forEach(action: Predicate<Application>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<AppListPageAsync>>.forEach(
                action: (Application) -> Boolean,
                executor: Executor
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.myData().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<Application>> {
            val values = mutableListOf<Application>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
