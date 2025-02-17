package com.nagornov.KafkaELK.infrastructure.persistence.kafka.repository;

import com.nagornov.KafkaELK.domain.enums.KafkaServiceTopic;
import com.nagornov.KafkaELK.sharedKernel.logs.model.Log;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class KafkaLogProducerRepository {

    private final KafkaTemplate<String, Log> kafkaLogServiceTemplate;

    public void sendMessage(@NotNull KafkaServiceTopic kafkaServiceTopic, @NotNull Log log) {
        kafkaLogServiceTemplate.send(
                kafkaServiceTopic.getTopicName(), log
        );
    }

}
