package com.nagornov.KafkaELK.domain.core;

import com.nagornov.KafkaELK.domain.core.interfaces.LogFactory;
import com.nagornov.KafkaELK.domain.core.interfaces.LogSender;
import com.nagornov.KafkaELK.domain.enums.LogLevel;
import com.nagornov.KafkaELK.domain.model.Log;
import com.nagornov.KafkaELK.domain.model.LogException;
import com.nagornov.KafkaELK.domain.model.LogHttp;
import jakarta.validation.constraints.NotNull;

public abstract class AbstractLogger {

    private final String layerName;
    private final LogFactory logFactory;
    private final LogSender logSender;

   protected AbstractLogger(
           String layerName,
           LogFactory logFactory,
           LogSender logSender
   ) {
        this.layerName = layerName;
        this.logFactory = logFactory;
        this.logSender = logSender;
    }

    private void sendInit(@NotNull String message, @NotNull LogLevel logLevel, @NotNull LogHttp logHttp, @NotNull LogException logException) {
       StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
       StackTraceElement relevantElement = null;

       for (StackTraceElement element : stackTrace) {
            if (element.getClassName().contains(layerName)) {
                relevantElement = element;
            }
       }

       Log log = logFactory.initLogObject(message, logLevel, layerName, relevantElement, logHttp, logException);

       logSender.sendLog(log);
    }

    // П
    // У
    // Т
    // И
    // Н

    //
    // LOG
    //

    public void log(String message, LogLevel logLevel) {
       sendInit(message, logLevel, null, null);
    }

    public void log(String message, LogLevel logLevel, LogHttp logHttp) {
       sendInit(message, logLevel, logHttp, null);
    }

    public void log(String message, LogLevel logLevel, LogHttp logHttp, LogException logException) {
       sendInit(message, logLevel, logHttp, logException);
    }

    //
    // ALL
    //

    public void all(String message) {
        log(message, LogLevel.ALL);
    }

    public void all(String message, LogHttp logHttp) {
        log(message, LogLevel.ALL, logHttp);
    }

    public void all(String message, LogHttp logHttp, LogException logException) {
        log(message, LogLevel.ALL, logHttp, logException);
    }

    //
    // TRACE
    //

    public void trace(@NotNull String message) {
        log(message, LogLevel.TRACE);
    }

    public void trace(@NotNull String message, LogHttp logHttp) {
        log(message, LogLevel.TRACE, logHttp);
    }

    public void trace(@NotNull String message, LogHttp logHttp, LogException logException) {
        log(message, LogLevel.TRACE, logHttp, logException);
    }

    //
    // DEBUG
    //

    public void debug(@NotNull String message) {
        log(message, LogLevel.DEBUG);
    }

    public void debug(@NotNull String message, LogHttp logHttp) {
        log(message, LogLevel.DEBUG, logHttp);
    }

    public void debug(@NotNull String message, LogHttp logHttp, LogException logException) {
        log(message, LogLevel.DEBUG, logHttp, logException);
    }

    //
    // INFO
    //

    public void info(@NotNull String message) {
        log(message, LogLevel.INFO);
    }

    public void info(@NotNull String message, LogHttp logHttp) {
        log(message, LogLevel.INFO, logHttp);
    }

    public void info(@NotNull String message, LogHttp logHttp, LogException logException) {
        log(message, LogLevel.INFO, logHttp, logException);
    }

    //
    // WARN
    //

    public void warn(@NotNull String message) {
        log(message, LogLevel.WARN);
    }

    public void warn(@NotNull String message, LogHttp logHttp) {
        log(message, LogLevel.WARN, logHttp);
    }

    public void warn(@NotNull String message, LogHttp logHttp, LogException logException) {
        log(message, LogLevel.WARN, logHttp, logException);
    }

    //
    // ERROR
    //

    public void error(@NotNull String message) {
        log(message, LogLevel.ERROR);
    }

    public void error(@NotNull String message, LogHttp logHttp) {
        log(message, LogLevel.ERROR, logHttp);
    }

    public void error(@NotNull String message, LogHttp logHttp, LogException logException) {
        log(message, LogLevel.ERROR, logHttp, logException);
    }

    //
    // FATAL
    //

    public void fatal(@NotNull String message) {
        log(message, LogLevel.FATAL);
    }

    public void fatal(@NotNull String message, LogHttp logHttp) {
        log(message, LogLevel.FATAL, logHttp);
    }

    public void fatal(@NotNull String message, LogHttp logHttp, LogException logException) {
        log(message, LogLevel.FATAL, logHttp, logException);
    }

}