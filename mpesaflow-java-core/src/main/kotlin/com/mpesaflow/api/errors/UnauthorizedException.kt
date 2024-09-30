package com.mpesaflow.api.errors

import com.google.common.collect.ListMultimap

class UnauthorizedException(
    headers: ListMultimap<String, String>,
    body: String,
    error: MpesaflowError,
) : MpesaflowServiceException(401, headers, body, error)
