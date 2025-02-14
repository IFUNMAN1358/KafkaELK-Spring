package com.nagornov.KafkaELK.domain.logger;

import com.nagornov.KafkaELK.sharedKernel.logs.service.AbstractLogger;
import com.nagornov.KafkaELK.sharedKernel.logs.interfaces.LogSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ControllerLogger extends AbstractLogger {

    protected ControllerLogger(
            @Value("${logger.service.name}") String serviceName,
            @Value("${logger.controller.directoryName}") String directoryName,
            LogSender kafkaLogSender
    ) {
        super(serviceName, directoryName, kafkaLogSender);
    }
}
