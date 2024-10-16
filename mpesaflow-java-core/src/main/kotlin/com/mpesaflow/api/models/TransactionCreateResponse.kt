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

@JsonDeserialize(builder = TransactionCreateResponse.Builder::class)
@NoAutoDetect
class TransactionCreateResponse
private constructor(
    private val transactionId: JsonField<String>,
    private val message: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    fun transactionId(): Optional<String> =
        Optional.ofNullable(transactionId.getNullable("transactionId"))

    fun message(): Optional<String> = Optional.ofNullable(message.getNullable("message"))

    @JsonProperty("transactionId") @ExcludeMissing fun _transactionId() = transactionId

    @JsonProperty("message") @ExcludeMissing fun _message() = message

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): TransactionCreateResponse = apply {
        if (!validated) {
            transactionId()
            message()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var transactionId: JsonField<String> = JsonMissing.of()
        private var message: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transactionCreateResponse: TransactionCreateResponse) = apply {
            this.transactionId = transactionCreateResponse.transactionId
            this.message = transactionCreateResponse.message
            additionalProperties(transactionCreateResponse.additionalProperties)
        }

        fun transactionId(transactionId: String) = transactionId(JsonField.of(transactionId))

        @JsonProperty("transactionId")
        @ExcludeMissing
        fun transactionId(transactionId: JsonField<String>) = apply {
            this.transactionId = transactionId
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

        fun build(): TransactionCreateResponse =
            TransactionCreateResponse(
                transactionId,
                message,
                additionalProperties.toUnmodifiable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TransactionCreateResponse && this.transactionId == other.transactionId && this.message == other.message && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(transactionId, message, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "TransactionCreateResponse{transactionId=$transactionId, message=$message, additionalProperties=$additionalProperties}"
}
