package com.mpesaflow.api.errors

import com.google.common.collect.ListMultimap

abstract class MpesaflowServiceException
@JvmOverloads
constructor(
    private val statusCode: Int,
    private val headers: ListMultimap<String, String>,
    private val body: String,
    private val error: MpesaflowError,
    message: String = "$statusCode: $error",
    cause: Throwable? = null
) : MpesaflowException(message, cause) {

    fun statusCode(): Int = statusCode

    fun headers(): ListMultimap<String, String> = headers

    fun body(): String = body

    fun error(): MpesaflowError = error
}
