package br.com.aco.marketbook.marketbook.controller.response

import org.springframework.validation.FieldError

class ErrorResponse(
    var httpCode: Int,
    var message: String,
    var internalCode: String,
    var errors: List<FieldError>?
)