package com.example.kafkakotlin.repositories

import avro.UserRegistration
import com.example.kafkakotlin.USER_REGISTRATION
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRegistrationProducer(val userRegistration: KafkaTemplate<String, UserRegistration>) {

    fun send(message: UserRegistration) {
        userRegistration.send(USER_REGISTRATION, message.id.toString(), message)
    }

}