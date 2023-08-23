package br.com.aco.marketbook.marketbook.extension

import br.com.aco.marketbook.marketbook.controller.request.PostCustomerRequest
import br.com.aco.marketbook.marketbook.controller.request.PutCustomerRequest
import br.com.aco.marketbook.marketbook.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel{
    return CustomerModel ( name = this.name, email =  this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel{
    return CustomerModel (id = id, name = this.name, email =  this.email)
}