package br.com.aco.marketbook.marketbook.repository

import br.com.aco.marketbook.marketbook.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<CustomerModel, Int> {
    fun findByNameContaining(it: String): List<CustomerModel>
}