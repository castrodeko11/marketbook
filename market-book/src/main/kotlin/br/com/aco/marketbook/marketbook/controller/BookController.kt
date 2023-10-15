package br.com.aco.marketbook.marketbook.controller

import br.com.aco.marketbook.marketbook.controller.request.PostBookRequest
import br.com.aco.marketbook.marketbook.controller.request.PutBookRequest
import br.com.aco.marketbook.marketbook.extension.toBookModel
import br.com.aco.marketbook.marketbook.model.BookModel
import br.com.aco.marketbook.marketbook.service.BookService
import br.com.aco.marketbook.marketbook.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun findAll(): List<BookModel> =
        bookService.findAll()

    @GetMapping("/active")
    fun findActives(): List<BookModel> =
        bookService.findActives()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookModel =
        bookService.findById(id)


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Int) {
        bookService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        val bookSaved = bookService.findById(id)

        bookService.update(book.toBookModel(bookSaved))
    }

}