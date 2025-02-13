package com.nagornov.KafkaELK.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LogException {

    private String type;
    private String message;
    private String stackTrace;

}
