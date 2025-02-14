package com.nagornov.KafkaELK.domain.domainService.kafka;

import com.nagornov.KafkaELK.infrastructure.persistence.kafka.repository.KafkaLogServiceProducerRepository;
import com.nagornov.KafkaELK.sharedKernel.logs.interfaces.LogSender;
import com.nagornov.KafkaELK.sharedKernel.logs.model.Log;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaLogSender implements LogSender {

    private final KafkaLogServiceProducerRepository kafkaLogServiceProducerRepository;

    @Override
    public void sendLog(@NotNull Log log) {
        kafkaLogServiceProducerRepository.sendLog(log);
    }

}
