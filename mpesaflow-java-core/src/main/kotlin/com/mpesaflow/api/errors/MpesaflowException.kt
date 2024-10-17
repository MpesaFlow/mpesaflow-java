package com.mpesaflow.api.errors

open class MpesaflowException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
