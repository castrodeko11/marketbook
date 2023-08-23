package br.com.aco.marketbook.marketbook.controller

import br.com.aco.marketbook.marketbook.controller.request.PostCustomerRequest
import br.com.aco.marketbook.marketbook.controller.request.PutCustomerRequest
import br.com.aco.marketbook.marketbook.extension.toCustomerModel
import br.com.aco.marketbook.marketbook.model.CustomerModel
import br.com.aco.marketbook.marketbook.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(
    val customerService: CustomerService
) {

    @GetMapping
    fun getAllCustomer(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAllCustomer(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest) {
        customerService.createCustomer(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerModel {
        return customerService.getCustomer(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        customerService.update(customer.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)
    }
}