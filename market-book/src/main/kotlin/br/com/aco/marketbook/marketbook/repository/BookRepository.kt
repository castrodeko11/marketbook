package br.com.aco.marketbook.marketbook.repository

import br.com.aco.marketbook.marketbook.enums.BookStatus
import br.com.aco.marketbook.marketbook.model.BookModel
import br.com.aco.marketbook.marketbook.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {
    fun findByNameContaining(it: String): List<BookModel>
    fun findByStatus(status: BookStatus): List<BookModel>
    fun findByCustomer(customer: CustomerModel): List<BookModel>
}