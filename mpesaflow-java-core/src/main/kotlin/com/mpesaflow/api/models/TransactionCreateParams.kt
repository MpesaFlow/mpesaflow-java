// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.mpesaflow.api.core.ExcludeMissing
import com.mpesaflow.api.core.JsonValue
import com.mpesaflow.api.core.NoAutoDetect
import com.mpesaflow.api.core.toUnmodifiable
import com.mpesaflow.api.models.*
import java.util.Objects
import java.util.Optional

class TransactionCreateParams
constructor(
    private val accountReference: String?,
    private val amount: Double?,
    private val mpesaRequestId: String?,
    private val phoneNumber: String?,
    private val transactionDesc: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun accountReference(): Optional<String> = Optional.ofNullable(accountReference)

    fun amount(): Optional<Double> = Optional.ofNullable(amount)

    fun mpesaRequestId(): Optional<String> = Optional.ofNullable(mpesaRequestId)

    fun phoneNumber(): Optional<String> = Optional.ofNullable(phoneNumber)

    fun transactionDesc(): Optional<String> = Optional.ofNullable(transactionDesc)

    @JvmSynthetic
    internal fun getBody(): TransactionCreateBody {
        return TransactionCreateBody(
            accountReference,
            amount,
            mpesaRequestId,
            phoneNumber,
            transactionDesc,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = TransactionCreateBody.Builder::class)
    @NoAutoDetect
    class TransactionCreateBody
    internal constructor(
        private val accountReference: String?,
        private val amount: Double?,
        private val mpesaRequestId: String?,
        private val phoneNumber: String?,
        private val transactionDesc: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        @JsonProperty("accountReference") fun accountReference(): String? = accountReference

        @JsonProperty("amount") fun amount(): Double? = amount

        @JsonProperty("mpesaRequestId") fun mpesaRequestId(): String? = mpesaRequestId

        @JsonProperty("phoneNumber") fun phoneNumber(): String? = phoneNumber

        @JsonProperty("transactionDesc") fun transactionDesc(): String? = transactionDesc

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var accountReference: String? = null
            private var amount: Double? = null
            private var mpesaRequestId: String? = null
            private var phoneNumber: String? = null
            private var transactionDesc: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(transactionCreateBody: TransactionCreateBody) = apply {
                this.accountReference = transactionCreateBody.accountReference
                this.amount = transactionCreateBody.amount
                this.mpesaRequestId = transactionCreateBody.mpesaRequestId
                this.phoneNumber = transactionCreateBody.phoneNumber
                this.transactionDesc = transactionCreateBody.transactionDesc
                additionalProperties(transactionCreateBody.additionalProperties)
            }

            @JsonProperty("accountReference")
            fun accountReference(accountReference: String) = apply {
                this.accountReference = accountReference
            }

            @JsonProperty("amount") fun amount(amount: Double) = apply { this.amount = amount }

            @JsonProperty("mpesaRequestId")
            fun mpesaRequestId(mpesaRequestId: String) = apply {
                this.mpesaRequestId = mpesaRequestId
            }

            @JsonProperty("phoneNumber")
            fun phoneNumber(phoneNumber: String) = apply { this.phoneNumber = phoneNumber }

            @JsonProperty("transactionDesc")
            fun transactionDesc(transactionDesc: String) = apply {
                this.transactionDesc = transactionDesc
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

            fun build(): TransactionCreateBody =
                TransactionCreateBody(
                    accountReference,
                    amount,
                    mpesaRequestId,
                    phoneNumber,
                    transactionDesc,
                    additionalProperties.toUnmodifiable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is TransactionCreateBody && this.accountReference == other.accountReference && this.amount == other.amount && this.mpesaRequestId == other.mpesaRequestId && this.phoneNumber == other.phoneNumber && this.transactionDesc == other.transactionDesc && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(accountReference, amount, mpesaRequestId, phoneNumber, transactionDesc, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "TransactionCreateBody{accountReference=$accountReference, amount=$amount, mpesaRequestId=$mpesaRequestId, phoneNumber=$phoneNumber, transactionDesc=$transactionDesc, additionalProperties=$additionalProperties}"
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TransactionCreateParams && this.accountReference == other.accountReference && this.amount == other.amount && this.mpesaRequestId == other.mpesaRequestId && this.phoneNumber == other.phoneNumber && this.transactionDesc == other.transactionDesc && this.additionalQueryParams == other.additionalQueryParams && this.additionalHeaders == other.additionalHeaders && this.additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(accountReference, amount, mpesaRequestId, phoneNumber, transactionDesc, additionalQueryParams, additionalHeaders, additionalBodyProperties) /* spotless:on */
    }

    override fun toString() =
        "TransactionCreateParams{accountReference=$accountReference, amount=$amount, mpesaRequestId=$mpesaRequestId, phoneNumber=$phoneNumber, transactionDesc=$transactionDesc, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var accountReference: String? = null
        private var amount: Double? = null
        private var mpesaRequestId: String? = null
        private var phoneNumber: String? = null
        private var transactionDesc: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transactionCreateParams: TransactionCreateParams) = apply {
            this.accountReference = transactionCreateParams.accountReference
            this.amount = transactionCreateParams.amount
            this.mpesaRequestId = transactionCreateParams.mpesaRequestId
            this.phoneNumber = transactionCreateParams.phoneNumber
            this.transactionDesc = transactionCreateParams.transactionDesc
            additionalQueryParams(transactionCreateParams.additionalQueryParams)
            additionalHeaders(transactionCreateParams.additionalHeaders)
            additionalBodyProperties(transactionCreateParams.additionalBodyProperties)
        }

        fun accountReference(accountReference: String) = apply {
            this.accountReference = accountReference
        }

        fun amount(amount: Double) = apply { this.amount = amount }

        fun mpesaRequestId(mpesaRequestId: String) = apply { this.mpesaRequestId = mpesaRequestId }

        fun phoneNumber(phoneNumber: String) = apply { this.phoneNumber = phoneNumber }

        fun transactionDesc(transactionDesc: String) = apply {
            this.transactionDesc = transactionDesc
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): TransactionCreateParams =
            TransactionCreateParams(
                accountReference,
                amount,
                mpesaRequestId,
                phoneNumber,
                transactionDesc,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }
}
