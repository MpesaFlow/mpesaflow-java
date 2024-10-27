package com.mpesaflow.api.errors

import com.google.common.collect.ListMultimap

class InternalServerException(
    statusCode: Int,
    headers: ListMultimap<String, String>,
    body: String,
    error: MpesaflowError,
) : MpesaflowServiceException(statusCode, headers, body, error)