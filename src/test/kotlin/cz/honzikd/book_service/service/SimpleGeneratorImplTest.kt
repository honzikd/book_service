package cz.honzikd.book_service.service

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SimpleGeneratorImplTest @Autowired constructor(
    private val simpleGeneratorImpl: SimpleGeneratorImpl
) {

    @Test
    fun `generateId returns String in format 'ID-000-000'`() {
        val id = simpleGeneratorImpl.generateId()
        assertTrue(id.matches(Regex.fromLiteral("ID-\\d{3}-\\d{3}")), "Id: $id doesn't match the expected pattern.")
    }
}