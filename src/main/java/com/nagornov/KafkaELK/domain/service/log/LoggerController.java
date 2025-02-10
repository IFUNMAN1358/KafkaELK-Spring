package com.nagornov.KafkaELK.domain.service.log;

import com.nagornov.KafkaELK.domain.core.AbstractLoggerService;
import com.nagornov.KafkaELK.domain.core.LogManager;
import org.springframework.stereotype.Service;

@Service
public class LoggerController extends AbstractLoggerService {

    protected LoggerController(LogManager logManager) {
        super(logManager, "controller");
    }
}
