package com.nagornov.KafkaELK.domain.domainService;

import com.nagornov.KafkaELK.domain.enums.KafkaServiceTopic;
import com.nagornov.KafkaELK.infrastructure.persistence.kafka.repository.KafkaLogProducerRepository;
import com.nagornov.KafkaELK.sharedKernel.logs.model.Log;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaLogProducerService {

    private final KafkaLogProducerRepository kafkaLogProducerRepository;

    public void sendMessage(@NotNull KafkaServiceTopic kafkaServiceTopic, @NotNull Log log) {
        kafkaLogProducerRepository.sendMessage(kafkaServiceTopic, log);
    }

}
