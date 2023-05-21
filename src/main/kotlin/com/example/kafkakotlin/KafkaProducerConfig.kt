package com.example.kafkakotlin

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaAdmin.NewTopics


@EnableKafka
@Configuration
class KafkaConfiguration {
    @Bean
    fun appTopics(): NewTopics? {
        return NewTopics(
            TopicBuilder.name(USER_REGISTRATION).compact().build(),
        )
    }
}

// constants for topics
const val USER_REGISTRATION = "user-registration"