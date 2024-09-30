package com.mpesaflow.api.errors

import com.google.common.collect.ListMultimap

class BadRequestException(
    headers: ListMultimap<String, String>,
    body: String,
    error: MpesaflowError,
) : MpesaflowServiceException(400, headers, body, error)
