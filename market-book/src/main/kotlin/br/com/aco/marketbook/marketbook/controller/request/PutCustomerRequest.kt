package br.com.aco.marketbook.marketbook.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty


class PutCustomerRequest(


    @field:NotEmpty(message = "Name cannot be empty")
    var name: String,

    @field:Email(regexp = ".+[@].+[\\.].+")
    @field:NotEmpty(message = "Email cannot be empty")
    var email: String
) {

}