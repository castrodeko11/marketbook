package br.com.aco.marketbook.marketbook.controller

import br.com.aco.marketbook.marketbook.controller.request.PostBookRequest
import br.com.aco.marketbook.marketbook.controller.request.PutBookRequest
import br.com.aco.marketbook.marketbook.controller.response.BookResponse
import br.com.aco.marketbook.marketbook.extension.toBookModel
import br.com.aco.marketbook.marketbook.extension.toResponse

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
        val customer = customerService.findById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun findAll(): List<BookResponse> =
        bookService.findAll().map { it.toResponse() }

    @GetMapping("/active")
    fun findActives(): List<BookResponse> =
        bookService.findActives().map { it.toResponse() }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookResponse =
        bookService.findById(id).toResponse()


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