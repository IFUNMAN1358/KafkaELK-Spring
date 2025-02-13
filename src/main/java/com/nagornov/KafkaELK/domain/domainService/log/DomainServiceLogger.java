package com.nagornov.KafkaELK.domain.domainService.log;

import com.nagornov.KafkaELK.domain.core.AbstractLogger;
import com.nagornov.KafkaELK.domain.core.interfaces.LogFactory;
import com.nagornov.KafkaELK.domain.core.interfaces.LogSender;
import org.springframework.stereotype.Service;

@Service
public class DomainServiceLogger extends AbstractLogger {

    protected DomainServiceLogger(LogFactory logFactoryImpl, LogSender kafkaLogSender) {
        super("domainService", logFactoryImpl, kafkaLogSender);
    }

}
