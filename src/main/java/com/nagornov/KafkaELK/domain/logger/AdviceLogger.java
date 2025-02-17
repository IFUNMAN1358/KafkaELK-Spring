package com.nagornov.KafkaELK.domain.logger;

import com.nagornov.KafkaELK.domain.domainService.KafkaLogProducerService;
import com.nagornov.KafkaELK.domain.enums.KafkaServiceTopic;
import com.nagornov.KafkaELK.sharedKernel.logs.model.Log;
import com.nagornov.KafkaELK.sharedKernel.logs.model.LoggerMetadata;
import com.nagornov.KafkaELK.sharedKernel.logs.service.AbstractLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AdviceLogger extends AbstractLogger {

    private final KafkaLogProducerService kafkaLogProducerService;

    @Override
    protected LoggerMetadata initLoggerMetadata() {
        return new LoggerMetadata("advice");
    }

    @Override
    protected void sendLog(Log log) {
        kafkaLogProducerService.sendMessage(KafkaServiceTopic.LOG_SERVICE_TOPIC, log);
    }

}