package cz.honzikd.book_service.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookCrudRepository: CrudRepository<Book, String> {
}