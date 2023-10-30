package br.com.aco.marketbook.marketbook.controller.response

import br.com.aco.marketbook.marketbook.enums.CustomerStatus
import jakarta.persistence.*

data class CustomerResponse(
    var id: Int? = null,

    var name: String,

    var email: String,

    var status: CustomerStatus

)
