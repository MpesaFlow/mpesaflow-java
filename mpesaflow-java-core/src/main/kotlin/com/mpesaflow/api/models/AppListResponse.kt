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
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = AppListResponse.Builder::class)
@NoAutoDetect
class AppListResponse
private constructor(
    private val data: JsonField<List<Application>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    fun data(): Optional<List<Application>> = Optional.ofNullable(data.getNullable("data"))

    @JsonProperty("data") @ExcludeMissing fun _data() = data

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): AppListResponse = apply {
        if (!validated) {
            data().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var data: JsonField<List<Application>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(appListResponse: AppListResponse) = apply {
            this.data = appListResponse.data
            additionalProperties(appListResponse.additionalProperties)
        }

        fun data(data: List<Application>) = data(JsonField.of(data))

        @JsonProperty("data")
        @ExcludeMissing
        fun data(data: JsonField<List<Application>>) = apply { this.data = data }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): AppListResponse =
            AppListResponse(data.map { it.toUnmodifiable() }, additionalProperties.toUnmodifiable())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AppListResponse && this.data == other.data && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(data, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "AppListResponse{data=$data, additionalProperties=$additionalProperties}"
}