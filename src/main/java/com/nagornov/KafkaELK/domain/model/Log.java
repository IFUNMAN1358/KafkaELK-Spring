package com.nagornov.KafkaELK.domain.model;

import lombok.*;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class Log {

    private Instant timestamp;
    private String level;
    private String message;
    private String traceId;
    private String spanId;
    private String layerName;
    private String service;
    private String file;
    private String method;
    private int line;
    private String userId;
    private LogHttp httpParams;
    private LogException exceptionParams;

    //////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////



    //////////////////////////////////////////
    // Methods
    //////////////////////////////////////////
}