package com.nagornov.KafkaELK.infrastructure.persistence.kafka.repository;

import com.nagornov.KafkaELK.domain.enums.KafkaServiceTopic;
import com.nagornov.KafkaELK.domain.model.Log;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class KafkaLogServiceProducerRepository {

    private final KafkaTemplate<String, Log> kafkaLogServiceTemplate;

    public void sendLog(@NotNull Log log) {
        kafkaLogServiceTemplate.send(
                KafkaServiceTopic.LOG_SERVICE_TOPIC.getTopicName(),
                log
        );
    }

}
