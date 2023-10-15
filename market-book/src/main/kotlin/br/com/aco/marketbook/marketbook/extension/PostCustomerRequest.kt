package br.com.aco.marketbook.marketbook.extension

import br.com.aco.marketbook.marketbook.controller.request.PostBookRequest
import br.com.aco.marketbook.marketbook.controller.request.PostCustomerRequest
import br.com.aco.marketbook.marketbook.controller.request.PutBookRequest
import br.com.aco.marketbook.marketbook.controller.request.PutCustomerRequest
import br.com.aco.marketbook.marketbook.enums.BookStatus
import br.com.aco.marketbook.marketbook.model.BookModel
import br.com.aco.marketbook.marketbook.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ENABLE,
        customer = customer
    )
}

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )

}