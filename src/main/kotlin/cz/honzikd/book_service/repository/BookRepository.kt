package cz.honzikd.book_service.repository

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.hibernate.annotations.UuidGenerator

@Entity
@AllArgsConstructor
@NoArgsConstructor
class Book(
    @Id
    @UuidGenerator
    @Column(name = "id")
    var id: String,

    @Column
    var author: String,

    @Column
    var title: String,

    @Column
    var isbn: String = "",
)

interface BookRepository {
    fun getAll(): List<Book>
    fun getById(id: String): Book
    fun create(book: Book): Book
    fun delete(id: String)
    fun update(book: Book, id: String): Book
}