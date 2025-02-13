package com.nagornov.KafkaELK.domain.core;

import com.nagornov.KafkaELK.domain.core.interfaces.LogFactory;
import com.nagornov.KafkaELK.domain.enums.LogLevel;
import com.nagornov.KafkaELK.domain.model.Log;
import com.nagornov.KafkaELK.domain.model.LogException;
import com.nagornov.KafkaELK.domain.model.LogHttp;
import com.nagornov.KafkaELK.infrastructure.configuration.properties.props.ServiceProperties;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class LogFactoryImpl implements LogFactory {

    private final ServiceProperties serviceProperties;

    public Log initLogObject(
            @NotNull String message,
            @NotNull LogLevel logLevel,
            @NotNull String layerName,
            @NotNull StackTraceElement relevantElement,
            @NotNull LogHttp logHttp,
            @NotNull LogException logException
    ) {
        return new Log(
                Instant.now(),
                logLevel.getLevel(),
                message,
                LogContextHolder.getTraceId(),
                LogContextHolder.getSpanId(),
                layerName,
                serviceProperties.getName(),
                relevantElement.getFileName(),
                relevantElement.getMethodName(),
                relevantElement.getLineNumber(),
                LogContextHolder.getUserId(),
                logHttp,
                logException
        );
    }
}
