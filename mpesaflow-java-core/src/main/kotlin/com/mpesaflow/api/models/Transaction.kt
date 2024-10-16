// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.mpesaflow.api.core.Enum
import com.mpesaflow.api.core.ExcludeMissing
import com.mpesaflow.api.core.JsonField
import com.mpesaflow.api.core.JsonMissing
import com.mpesaflow.api.core.JsonValue
import com.mpesaflow.api.core.NoAutoDetect
import com.mpesaflow.api.core.toUnmodifiable
import com.mpesaflow.api.errors.MpesaflowInvalidDataException
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = Transaction.Builder::class)
@NoAutoDetect
class Transaction
private constructor(
    private val transactionId: JsonField<String>,
    private val amount: JsonField<Double>,
    private val phoneNumber: JsonField<String>,
    private val accountReference: JsonField<String>,
    private val transactionDesc: JsonField<String>,
    private val mpesaRequestId: JsonField<String>,
    private val status: JsonField<Status>,
    private val resultDesc: JsonField<String>,
    private val dateCreated: JsonField<OffsetDateTime>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    fun transactionId(): Optional<String> =
        Optional.ofNullable(transactionId.getNullable("transactionId"))

    fun amount(): Optional<Double> = Optional.ofNullable(amount.getNullable("amount"))

    fun phoneNumber(): Optional<String> =
        Optional.ofNullable(phoneNumber.getNullable("phoneNumber"))

    fun accountReference(): Optional<String> =
        Optional.ofNullable(accountReference.getNullable("accountReference"))

    fun transactionDesc(): Optional<String> =
        Optional.ofNullable(transactionDesc.getNullable("transactionDesc"))

    fun mpesaRequestId(): Optional<String> =
        Optional.ofNullable(mpesaRequestId.getNullable("mpesaRequestId"))

    fun status(): Optional<Status> = Optional.ofNullable(status.getNullable("status"))

    fun resultDesc(): Optional<String> = Optional.ofNullable(resultDesc.getNullable("resultDesc"))

    fun dateCreated(): Optional<OffsetDateTime> =
        Optional.ofNullable(dateCreated.getNullable("date_created"))

    @JsonProperty("transactionId") @ExcludeMissing fun _transactionId() = transactionId

    @JsonProperty("amount") @ExcludeMissing fun _amount() = amount

    @JsonProperty("phoneNumber") @ExcludeMissing fun _phoneNumber() = phoneNumber

    @JsonProperty("accountReference") @ExcludeMissing fun _accountReference() = accountReference

    @JsonProperty("transactionDesc") @ExcludeMissing fun _transactionDesc() = transactionDesc

    @JsonProperty("mpesaRequestId") @ExcludeMissing fun _mpesaRequestId() = mpesaRequestId

    @JsonProperty("status") @ExcludeMissing fun _status() = status

    @JsonProperty("resultDesc") @ExcludeMissing fun _resultDesc() = resultDesc

    @JsonProperty("date_created") @ExcludeMissing fun _dateCreated() = dateCreated

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Transaction = apply {
        if (!validated) {
            transactionId()
            amount()
            phoneNumber()
            accountReference()
            transactionDesc()
            mpesaRequestId()
            status()
            resultDesc()
            dateCreated()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var transactionId: JsonField<String> = JsonMissing.of()
        private var amount: JsonField<Double> = JsonMissing.of()
        private var phoneNumber: JsonField<String> = JsonMissing.of()
        private var accountReference: JsonField<String> = JsonMissing.of()
        private var transactionDesc: JsonField<String> = JsonMissing.of()
        private var mpesaRequestId: JsonField<String> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var resultDesc: JsonField<String> = JsonMissing.of()
        private var dateCreated: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transaction: Transaction) = apply {
            this.transactionId = transaction.transactionId
            this.amount = transaction.amount
            this.phoneNumber = transaction.phoneNumber
            this.accountReference = transaction.accountReference
            this.transactionDesc = transaction.transactionDesc
            this.mpesaRequestId = transaction.mpesaRequestId
            this.status = transaction.status
            this.resultDesc = transaction.resultDesc
            this.dateCreated = transaction.dateCreated
            additionalProperties(transaction.additionalProperties)
        }

        fun transactionId(transactionId: String) = transactionId(JsonField.of(transactionId))

        @JsonProperty("transactionId")
        @ExcludeMissing
        fun transactionId(transactionId: JsonField<String>) = apply {
            this.transactionId = transactionId
        }

        fun amount(amount: Double) = amount(JsonField.of(amount))

        @JsonProperty("amount")
        @ExcludeMissing
        fun amount(amount: JsonField<Double>) = apply { this.amount = amount }

        fun phoneNumber(phoneNumber: String) = phoneNumber(JsonField.of(phoneNumber))

        @JsonProperty("phoneNumber")
        @ExcludeMissing
        fun phoneNumber(phoneNumber: JsonField<String>) = apply { this.phoneNumber = phoneNumber }

        fun accountReference(accountReference: String) =
            accountReference(JsonField.of(accountReference))

        @JsonProperty("accountReference")
        @ExcludeMissing
        fun accountReference(accountReference: JsonField<String>) = apply {
            this.accountReference = accountReference
        }

        fun transactionDesc(transactionDesc: String) =
            transactionDesc(JsonField.of(transactionDesc))

        @JsonProperty("transactionDesc")
        @ExcludeMissing
        fun transactionDesc(transactionDesc: JsonField<String>) = apply {
            this.transactionDesc = transactionDesc
        }

        fun mpesaRequestId(mpesaRequestId: String) = mpesaRequestId(JsonField.of(mpesaRequestId))

        @JsonProperty("mpesaRequestId")
        @ExcludeMissing
        fun mpesaRequestId(mpesaRequestId: JsonField<String>) = apply {
            this.mpesaRequestId = mpesaRequestId
        }

        fun status(status: Status) = status(JsonField.of(status))

        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<Status>) = apply { this.status = status }

        fun resultDesc(resultDesc: String) = resultDesc(JsonField.of(resultDesc))

        @JsonProperty("resultDesc")
        @ExcludeMissing
        fun resultDesc(resultDesc: JsonField<String>) = apply { this.resultDesc = resultDesc }

        fun dateCreated(dateCreated: OffsetDateTime) = dateCreated(JsonField.of(dateCreated))

        @JsonProperty("date_created")
        @ExcludeMissing
        fun dateCreated(dateCreated: JsonField<OffsetDateTime>) = apply {
            this.dateCreated = dateCreated
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

        fun build(): Transaction =
            Transaction(
                transactionId,
                amount,
                phoneNumber,
                accountReference,
                transactionDesc,
                mpesaRequestId,
                status,
                resultDesc,
                dateCreated,
                additionalProperties.toUnmodifiable(),
            )
    }

    class Status
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Status && this.value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val PENDING = Status(JsonField.of("pending"))

            @JvmField val COMPLETED = Status(JsonField.of("completed"))

            @JvmField val FAILED = Status(JsonField.of("failed"))

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            PENDING,
            COMPLETED,
            FAILED,
        }

        enum class Value {
            PENDING,
            COMPLETED,
            FAILED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                PENDING -> Value.PENDING
                COMPLETED -> Value.COMPLETED
                FAILED -> Value.FAILED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                PENDING -> Known.PENDING
                COMPLETED -> Known.COMPLETED
                FAILED -> Known.FAILED
                else -> throw MpesaflowInvalidDataException("Unknown Status: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Transaction && this.transactionId == other.transactionId && this.amount == other.amount && this.phoneNumber == other.phoneNumber && this.accountReference == other.accountReference && this.transactionDesc == other.transactionDesc && this.mpesaRequestId == other.mpesaRequestId && this.status == other.status && this.resultDesc == other.resultDesc && this.dateCreated == other.dateCreated && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(transactionId, amount, phoneNumber, accountReference, transactionDesc, mpesaRequestId, status, resultDesc, dateCreated, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "Transaction{transactionId=$transactionId, amount=$amount, phoneNumber=$phoneNumber, accountReference=$accountReference, transactionDesc=$transactionDesc, mpesaRequestId=$mpesaRequestId, status=$status, resultDesc=$resultDesc, dateCreated=$dateCreated, additionalProperties=$additionalProperties}"
}
