package com.kamerling.example.app

import io.micrometer.observation.annotation.Observed
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ConsumerExample {

    companion object {
        val logger: Logger = LoggerFactory.getLogger("Consumer")
    }

    @Observed(name = "kafka.message.received")
    @KafkaListener(topics = ["topic"])
    fun listen(record: ConsumerRecord<String, String>) {
        logger.info("Receiving: ${record.value()}")
    }
}
