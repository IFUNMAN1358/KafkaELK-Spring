package com.nagornov.KafkaELK.domain.service.log;

import com.nagornov.KafkaELK.domain.core.AbstractLoggerService;
import com.nagornov.KafkaELK.domain.core.LogManager;
import org.springframework.stereotype.Service;

@Service
public class LoggerAdvice extends AbstractLoggerService {

    protected LoggerAdvice(LogManager logManager) {
        super(logManager, "advice");
    }

}
