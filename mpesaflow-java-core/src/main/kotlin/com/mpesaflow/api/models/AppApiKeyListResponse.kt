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

@JsonDeserialize(builder = AppApiKeyListResponse.Builder::class)
@NoAutoDetect
class AppApiKeyListResponse
private constructor(
    private val id: JsonField<String>,
    private val keyName: JsonField<String>,
    private val applicationId: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    fun keyName(): Optional<String> = Optional.ofNullable(keyName.getNullable("keyName"))

    fun applicationId(): Optional<String> =
        Optional.ofNullable(applicationId.getNullable("applicationId"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("keyName") @ExcludeMissing fun _keyName() = keyName

    @JsonProperty("applicationId") @ExcludeMissing fun _applicationId() = applicationId

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): AppApiKeyListResponse = apply {
        if (!validated) {
            id()
            keyName()
            applicationId()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var keyName: JsonField<String> = JsonMissing.of()
        private var applicationId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(appApiKeyListResponse: AppApiKeyListResponse) = apply {
            this.id = appApiKeyListResponse.id
            this.keyName = appApiKeyListResponse.keyName
            this.applicationId = appApiKeyListResponse.applicationId
            additionalProperties(appApiKeyListResponse.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        fun keyName(keyName: String) = keyName(JsonField.of(keyName))

        @JsonProperty("keyName")
        @ExcludeMissing
        fun keyName(keyName: JsonField<String>) = apply { this.keyName = keyName }

        fun applicationId(applicationId: String) = applicationId(JsonField.of(applicationId))

        @JsonProperty("applicationId")
        @ExcludeMissing
        fun applicationId(applicationId: JsonField<String>) = apply {
            this.applicationId = applicationId
        }

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

        fun build(): AppApiKeyListResponse =
            AppApiKeyListResponse(
                id,
                keyName,
                applicationId,
                additionalProperties.toUnmodifiable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AppApiKeyListResponse && this.id == other.id && this.keyName == other.keyName && this.applicationId == other.applicationId && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(id, keyName, applicationId, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "AppApiKeyListResponse{id=$id, keyName=$keyName, applicationId=$applicationId, additionalProperties=$additionalProperties}"
}
