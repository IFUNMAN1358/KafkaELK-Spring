package com.nagornov.KafkaELK.domain.core;

import com.nagornov.KafkaELK.domain.enums.LogLevel;
import com.nagornov.KafkaELK.domain.model.Log;
import jakarta.validation.constraints.NotNull;

public abstract class AbstractLoggerService {

    private final LogManager logManager;
    private final String layerName;

   protected AbstractLoggerService(LogManager logManager, String layerName) {
        this.logManager = logManager;
        this.layerName = layerName;
    }

    public void log(@NotNull String message, @NotNull LogLevel logLevel) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement relevantElement = getRelevantStackTraceElement(stackTrace);

        Log log = logManager.initLogObject(message, logLevel, layerName, relevantElement);
        logManager.sendLog(log);
    }

    public void all(@NotNull String message) {
        log(message, LogLevel.ALL);
    }

    public void trace(@NotNull String message) {
        log(message, LogLevel.TRACE);
    }

    public void debug(@NotNull String message) {
        log(message, LogLevel.DEBUG);
    }

    public void info(@NotNull String message) {
        log(message, LogLevel.INFO);
    }

    public void warn(@NotNull String message) {
        log(message, LogLevel.WARN);
    }

    public void error(@NotNull String message) {
        log(message, LogLevel.ERROR);
    }

    public void fatal(@NotNull String message) {
        log(message, LogLevel.FATAL);
    }

    private StackTraceElement getRelevantStackTraceElement(@NotNull StackTraceElement[] stackTrace) {
        for (StackTraceElement element : stackTrace) {
            if (element.getClassName().contains(layerName)) {
                return element;
            }
        }
        return stackTrace[stackTrace.length - 1];
    }
}
