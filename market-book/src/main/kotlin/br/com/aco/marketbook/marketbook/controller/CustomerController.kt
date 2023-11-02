package br.com.aco.marketbook.marketbook.controller

import br.com.aco.marketbook.marketbook.controller.request.PostCustomerRequest
import br.com.aco.marketbook.marketbook.controller.request.PutCustomerRequest
import br.com.aco.marketbook.marketbook.controller.response.CustomerResponse
import br.com.aco.marketbook.marketbook.extension.toCustomerModel
import br.com.aco.marketbook.marketbook.extension.toResponse
import br.com.aco.marketbook.marketbook.service.CustomerService
import jakarta.validation.Valid

import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("customer")
@Validated
class CustomerController(
    val customerService: CustomerService
) {

    @GetMapping
    fun getAllCustomer(@RequestParam name: String?): List<CustomerResponse> {
        return customerService.getAllCustomer(name).map { it.toResponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody @Valid customer: PostCustomerRequest) {
        customerService.createCustomer(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerResponse {
        return customerService.findById(id).toResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody @Valid customer: PutCustomerRequest) {
        val customerSaved = customerService.findById(id)
        customerService.update(customer.toCustomerModel(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)
    }
}