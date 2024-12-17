package cz.honzikd.book_service.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookDbRepository : JpaRepository<Book, String> {
}