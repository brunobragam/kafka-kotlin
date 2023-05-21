package com.example.kafkakotlin.transport.http

import avro.UserRegistration
import com.example.kafkakotlin.repositories.UserRegistrationProducer
import com.example.kafkakotlin.transport.dto.UserRegistrationDTO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("api")
class UserController(val stockQuoteProducer: UserRegistrationProducer) {

    @PostMapping("/quotes")
    fun create(@RequestBody stockQuoteDTO: UserRegistrationDTO): ResponseEntity<UserRegistrationDTO> {
        val stockQuote = UserRegistration(stockQuoteDTO.id, stockQuoteDTO.name, stockQuoteDTO.userName)
        stockQuoteProducer.send(stockQuote)
        return ResponseEntity.ok(stockQuoteDTO)
    }
}