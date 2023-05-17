package com.example.kafkakotlin

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaAdmin


@EnableKafka

@Configuration
class KafkaProducerConfig {
    // TOPICS
    val quotesTopic = "stock-quotes-topic"
    val leveragePriceTopic = "leverage-prices-topic"

    @Bean
    fun appTopics(): KafkaAdmin.NewTopics? {
        return KafkaAdmin.NewTopics(
            TopicBuilder.name(quotesTopic).build(),
            TopicBuilder.name(leveragePriceTopic)
                .compact().build(),
        )
    }
}