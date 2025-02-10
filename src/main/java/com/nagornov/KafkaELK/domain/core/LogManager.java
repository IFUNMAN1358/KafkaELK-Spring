package com.nagornov.KafkaELK.domain.core;

import com.nagornov.KafkaELK.domain.enums.LogLevel;
import com.nagornov.KafkaELK.domain.model.Log;
import com.nagornov.KafkaELK.domain.service.kafka.KafkaLogServiceProducerService;
import com.nagornov.KafkaELK.infrastructure.configuration.properties.props.ServiceProperties;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogManager {

    private final ServiceProperties serviceProperties;
    private final KafkaLogServiceProducerService kafkaLogServiceProducerService;

    public Log initLogObject(
            @NotNull String message,
            @NotNull LogLevel logLevel,
            @NotNull String layerName,
            @NotNull StackTraceElement relevantElement
    ) {
        Log log = new Log();
        log.updateCurrentTimestamp();
        log.updateContent(
                message, logLevel.getLevel()
        );
        log.updateTraceMetadata(
                TraceContextHolder.getTraceId(), TraceContextHolder.getSpanId()
        );
        log.updateService(serviceProperties.getName());
        log.updateLayerName(layerName);
        log.updateCallerMetadata(relevantElement);
        log.updateUserId(null);
        log.setHttpParamsAsNull();
        log.setExceptionParamsAsNull();
        return log;
    }

    public void sendLog(@NotNull Log log) {
        kafkaLogServiceProducerService.sendLog(log);
    }

}
