package cz.honzikd.book_service

import cz.honzikd.book_service.repository.Book
import cz.honzikd.book_service.repository.BookRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookListRepositoryImplTest @Autowired constructor(
    private val bookRepository: BookRepository,
) {

    @Test
    fun `given valid paramters when calling create then book is created`() {
        val book = Book("123456", "Jenda", "Ze zivota hmyzu")
        val result = bookRepository.create(book)
        assertEquals(result, book)
    }

    @Test
    fun `existing book is updated`() {
        val bookToUpdate = bookRepository.getAll().last()
        bookToUpdate.title = "updatedTitle"
        val result = bookRepository.update(bookToUpdate, bookToUpdate.id)
        assertEquals(bookToUpdate, result)
    }
}