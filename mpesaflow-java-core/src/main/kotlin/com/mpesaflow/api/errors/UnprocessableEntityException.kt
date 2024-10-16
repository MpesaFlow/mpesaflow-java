package com.mpesaflow.api.errors

import com.google.common.collect.ListMultimap

class UnprocessableEntityException(
    headers: ListMultimap<String, String>,
    body: String,
    error: MpesaflowError,
) : MpesaflowServiceException(422, headers, body, error)
