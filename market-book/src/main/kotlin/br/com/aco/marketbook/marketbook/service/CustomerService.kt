package br.com.aco.marketbook.marketbook.service

import br.com.aco.marketbook.marketbook.enums.CustomerStatus
import br.com.aco.marketbook.marketbook.enums.Erros
import br.com.aco.marketbook.marketbook.exception.NotFoundException
import br.com.aco.marketbook.marketbook.model.CustomerModel
import br.com.aco.marketbook.marketbook.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService

) {

    fun getAllCustomer(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun createCustomer(customer: CustomerModel) {
        customerRepository.save(customer)
    }


    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow{  NotFoundException(Erros.ML201.message.format(id), Erros.ML201.code) }
    }

    fun update(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw Exception("Customer not found")
        }
        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        val customer = findById(id)
        bookService.deleteByCustomer(customer)

        customer.status = CustomerStatus.DISABLE
        customerRepository.save(customer)
    }
}

