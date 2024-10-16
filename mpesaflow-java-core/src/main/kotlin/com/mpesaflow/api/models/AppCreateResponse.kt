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

@JsonDeserialize(builder = AppCreateResponse.Builder::class)
@NoAutoDetect
class AppCreateResponse
private constructor(
    private val applicationId: JsonField<String>,
    private val message: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    fun applicationId(): Optional<String> =
        Optional.ofNullable(applicationId.getNullable("applicationId"))

    fun message(): Optional<String> = Optional.ofNullable(message.getNullable("message"))

    @JsonProperty("applicationId") @ExcludeMissing fun _applicationId() = applicationId

    @JsonProperty("message") @ExcludeMissing fun _message() = message

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): AppCreateResponse = apply {
        if (!validated) {
            applicationId()
            message()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var applicationId: JsonField<String> = JsonMissing.of()
        private var message: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(appCreateResponse: AppCreateResponse) = apply {
            this.applicationId = appCreateResponse.applicationId
            this.message = appCreateResponse.message
            additionalProperties(appCreateResponse.additionalProperties)
        }

        fun applicationId(applicationId: String) = applicationId(JsonField.of(applicationId))

        @JsonProperty("applicationId")
        @ExcludeMissing
        fun applicationId(applicationId: JsonField<String>) = apply {
            this.applicationId = applicationId
        }

        fun message(message: String) = message(JsonField.of(message))

        @JsonProperty("message")
        @ExcludeMissing
        fun message(message: JsonField<String>) = apply { this.message = message }

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

        fun build(): AppCreateResponse =
            AppCreateResponse(
                applicationId,
                message,
                additionalProperties.toUnmodifiable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AppCreateResponse && this.applicationId == other.applicationId && this.message == other.message && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(applicationId, message, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "AppCreateResponse{applicationId=$applicationId, message=$message, additionalProperties=$additionalProperties}"
}
