package cz.honzikd.book_service.service

import cz.honzikd.book_service.repository.Book
import cz.honzikd.book_service.repository.BookDbRepository
import org.springframework.stereotype.Service

@Service
internal class BookService(
    private val bookRepository : BookDbRepository
) : BookRestController {

    override fun getById(id: String): Book {
        return bookRepository.getById(id)
    }

    override fun getAll(): List<Book> {
        return bookRepository.findAll()
    }

    override fun create(book: Book): Book {
        return bookRepository.save<Book>(book)
    }

    override fun delete(id: String) {
        bookRepository.delete(bookRepository.findById(id).get())
    }

    override fun update(book: Book): Book {
        return bookRepository.save<Book>(book)
    }
}