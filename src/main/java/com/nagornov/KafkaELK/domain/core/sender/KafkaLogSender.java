package com.nagornov.KafkaELK.domain.core.sender;

import com.nagornov.KafkaELK.domain.core.interfaces.LogSender;
import com.nagornov.KafkaELK.domain.model.Log;
import com.nagornov.KafkaELK.domain.domainService.kafka.KafkaLogServiceProducerService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaLogSender implements LogSender {

    private final KafkaLogServiceProducerService kafkaLogServiceProducerService;

    @Override
    public void sendLog(@NotNull Log log) {
        kafkaLogServiceProducerService.sendLog(log);
    }

}
