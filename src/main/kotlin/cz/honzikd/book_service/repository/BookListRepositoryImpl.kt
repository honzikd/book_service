package cz.honzikd.book_service.repository

import cz.honzikd.book_service.service.IdGenerator
import org.springframework.stereotype.Component

@Component
internal class BookListRepositoryImpl(
    val books: MutableList<Book>,
    val idGenerator: IdGenerator,
    ) : BookRepository {

    override fun getAll(): List<Book> {
        return books
    }

    override fun getById(id: String): Book {
        return books.first { it.id == id }
    }

    override fun create(book: Book): Book {
        books.add(book.also { it.id = idGenerator.generateId() })
        return book
    }

    override fun delete(id: String) {
        books.removeIf { it.id == id }
    }

    override fun update(book: Book, id: String): Book {
        return books.firstOrNull { it.id == id }?.also {
                it.author = book.author
                it.title = book.title
                it.isbn = book.isbn
            } ?: create(book)
    }
}