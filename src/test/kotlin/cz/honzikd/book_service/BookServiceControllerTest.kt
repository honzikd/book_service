package cz.honzikd.book_service

import com.ninjasquad.springmockk.MockkBean
import cz.honzikd.book_service.repository.Book
import cz.honzikd.book_service.repository.BookRepository
import cz.honzikd.book_service.service.BookService
import io.mockk.every
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceControllerTest @Autowired constructor(
    private val bookService: BookService,
) {

    @MockkBean
    private lateinit var bookRepository: BookRepository

    @Test
    fun `Given valid id a book is returned`() {
        val expected = Book("abc", "author", "book title", "123456")
        every { bookRepository.getById("abcd") } returns expected
        val result = bookService.getById("abcd")
        assertEquals(expected.title, result.title)
    }

    @Test
    fun `getAll returns all books`() {
        val expected = listOf(
            Book("abcd", "first", "last", "title")
        )
        every { bookRepository.getAll() } returns expected

        val result = bookService.getAll()
        assertEquals(1, result.size)
    }

    @Test
    fun `existing book is updated`() {
        val original = Book("abcd", "first", "last", "title")
        val updated = Book("abcd", "newFirst", "newLast", "newTitle")
        every { bookRepository.getAll() } returns mutableListOf(original)
        every { bookRepository.update(any(), any()) } returns updated
        val result = bookService.update(updated, "abcd")
        assertEquals(updated.id, result.id)
        assertEquals(updated.title, result.title)
    }
}