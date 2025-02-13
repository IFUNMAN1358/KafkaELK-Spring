package com.nagornov.KafkaELK.domain.core.interfaces;

import com.nagornov.KafkaELK.domain.enums.LogLevel;
import com.nagornov.KafkaELK.domain.model.Log;
import com.nagornov.KafkaELK.domain.model.LogException;
import com.nagornov.KafkaELK.domain.model.LogHttp;

public interface LogFactory {

    Log initLogObject(
            String message,
            LogLevel logLevel,
            String layerName,
            StackTraceElement relevantElement,
            LogHttp logHttp,
            LogException logException
    );
}
