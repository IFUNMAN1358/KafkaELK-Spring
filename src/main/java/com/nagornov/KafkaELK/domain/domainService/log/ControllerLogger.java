package com.nagornov.KafkaELK.domain.domainService.log;

import com.nagornov.KafkaELK.domain.core.AbstractLogger;
import com.nagornov.KafkaELK.domain.core.interfaces.LogFactory;
import com.nagornov.KafkaELK.domain.core.interfaces.LogSender;
import org.springframework.stereotype.Service;

@Service
public class ControllerLogger extends AbstractLogger {

    protected ControllerLogger(LogFactory logFactoryImpl, LogSender KafkaLogSender) {
        super("controller", logFactoryImpl, KafkaLogSender);
    }
}
