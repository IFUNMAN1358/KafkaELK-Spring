package com.nagornov.KafkaELK.domain.domainService.log;

import com.nagornov.KafkaELK.domain.core.AbstractLogger;
import com.nagornov.KafkaELK.domain.core.interfaces.LogFactory;
import com.nagornov.KafkaELK.domain.core.interfaces.LogSender;
import org.springframework.stereotype.Service;

@Service
public class AdviceLogger extends AbstractLogger {

    protected AdviceLogger(LogFactory logFactoryImpl, LogSender KafkaLogSender) {
        super("advice", logFactoryImpl, KafkaLogSender);
    }

}
