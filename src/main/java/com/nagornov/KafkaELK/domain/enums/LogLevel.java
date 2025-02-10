package com.nagornov.KafkaELK.domain.enums;

import lombok.Getter;

@Getter
public enum LogLevel {

    ALL("ALL"),
    TRACE("TRACE"),
    DEBUG("DEBUG"),
    INFO("INFO"),
    WARN("WARN"),
    ERROR("ERROR"),
    FATAL("FATAL");

    private final String level;

    LogLevel(String level) {
        this.level = level;
    }

}
