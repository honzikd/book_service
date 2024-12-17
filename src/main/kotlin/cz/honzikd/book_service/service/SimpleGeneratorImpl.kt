package cz.honzikd.book_service.service

import org.springframework.stereotype.Service

@Service
class SimpleGeneratorImpl : IdGenerator {
    override fun generateId(): String {
        return String.format("ID-%d-%d", getPart(), getPart())
    }

    private fun getPart(): Int {
        return ((Math.random() * 900) + 100).toInt()
    }
}