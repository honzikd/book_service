package cz.honzikd.book_service.service

import cz.honzikd.book_service.repository.Book
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
interface BookRestController {
    @GetMapping("/{id}", produces = ["application/json"])
    fun getById(@PathVariable id: String): Book

    @GetMapping("/all", produces = ["application/json"])
    fun getAll(): List<Book>

    @PostMapping
    fun create(@RequestBody book: Book): Book

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String)

    @PutMapping("/{id}")
    fun update(@RequestBody book: Book): Book
}