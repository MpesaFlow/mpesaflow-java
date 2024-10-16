package com.mpesaflow.api.errors

import com.google.common.collect.ListMultimap

class NotFoundException(
    headers: ListMultimap<String, String>,
    body: String,
    error: MpesaflowError,
) : MpesaflowServiceException(404, headers, body, error)
