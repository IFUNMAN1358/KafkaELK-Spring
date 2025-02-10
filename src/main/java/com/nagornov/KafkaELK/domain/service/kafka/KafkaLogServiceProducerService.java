package com.nagornov.KafkaELK.domain.service.kafka;

import com.nagornov.KafkaELK.domain.model.Log;
import com.nagornov.KafkaELK.infrastructure.persistence.kafka.repository.KafkaLogServiceProducerRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaLogServiceProducerService {

    private final KafkaLogServiceProducerRepository kafkaLogServiceProducerRepository;

    public void sendLog(@NotNull Log log) {
        kafkaLogServiceProducerRepository.sendLog(log);
    }

}
