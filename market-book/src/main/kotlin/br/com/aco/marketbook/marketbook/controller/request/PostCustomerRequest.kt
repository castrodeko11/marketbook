package br.com.aco.marketbook.marketbook.controller.request

import br.com.aco.marketbook.marketbook.validation.EmailAvailable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

class PostCustomerRequest(

    @field:NotEmpty(message = "Name cannot be empty")
    var name: String,

    @field:Email(regexp = ".+[@].+[\\.].+")
    @field:NotEmpty(message = "Email cannot be empty")
    @EmailAvailable
    var email: String

)