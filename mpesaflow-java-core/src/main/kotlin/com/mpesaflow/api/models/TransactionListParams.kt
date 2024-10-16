// File generated from our OpenAPI spec by Stainless.

package com.mpesaflow.api.models

import com.mpesaflow.api.core.NoAutoDetect
import com.mpesaflow.api.core.toUnmodifiable
import com.mpesaflow.api.models.*
import java.util.Objects
import java.util.Optional

class TransactionListParams
constructor(
    private val appId: String,
    private val endingBefore: String?,
    private val limit: Long?,
    private val startingAfter: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun appId(): String = appId

    fun endingBefore(): Optional<String> = Optional.ofNullable(endingBefore)

    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    fun startingAfter(): Optional<String> = Optional.ofNullable(startingAfter)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.appId.let { params.put("appId", listOf(it.toString())) }
        this.endingBefore?.let { params.put("ending_before", listOf(it.toString())) }
        this.limit?.let { params.put("limit", listOf(it.toString())) }
        this.startingAfter?.let { params.put("starting_after", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toUnmodifiable()
    }

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TransactionListParams && this.appId == other.appId && this.endingBefore == other.endingBefore && this.limit == other.limit && this.startingAfter == other.startingAfter && this.additionalQueryParams == other.additionalQueryParams && this.additionalHeaders == other.additionalHeaders /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(appId, endingBefore, limit, startingAfter, additionalQueryParams, additionalHeaders) /* spotless:on */
    }

    override fun toString() =
        "TransactionListParams{appId=$appId, endingBefore=$endingBefore, limit=$limit, startingAfter=$startingAfter, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var appId: String? = null
        private var endingBefore: String? = null
        private var limit: Long? = null
        private var startingAfter: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transactionListParams: TransactionListParams) = apply {
            this.appId = transactionListParams.appId
            this.endingBefore = transactionListParams.endingBefore
            this.limit = transactionListParams.limit
            this.startingAfter = transactionListParams.startingAfter
            additionalQueryParams(transactionListParams.additionalQueryParams)
            additionalHeaders(transactionListParams.additionalHeaders)
        }

        fun appId(appId: String) = apply { this.appId = appId }

        fun endingBefore(endingBefore: String) = apply { this.endingBefore = endingBefore }

        fun limit(limit: Long) = apply { this.limit = limit }

        fun startingAfter(startingAfter: String) = apply { this.startingAfter = startingAfter }

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

        fun build(): TransactionListParams =
            TransactionListParams(
                checkNotNull(appId) { "`appId` is required but was not set" },
                endingBefore,
                limit,
                startingAfter,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            )
    }
}
