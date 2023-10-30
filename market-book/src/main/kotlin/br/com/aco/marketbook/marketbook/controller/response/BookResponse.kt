package br.com.aco.marketbook.marketbook.controller.response

import br.com.aco.marketbook.marketbook.enums.BookStatus
import br.com.aco.marketbook.marketbook.model.CustomerModel
import java.math.BigDecimal

class BookResponse(

    var id: Int? = null,

    var name: String,

    var price: BigDecimal,

    var customer: CustomerModel? = null,

    var status: BookStatus? = null
)
