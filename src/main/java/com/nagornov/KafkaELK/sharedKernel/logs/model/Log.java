package com.nagornov.KafkaELK.sharedKernel.logs.model;

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
    private String serviceName;
    private String directoryName;
    private String fileName;
    private String methodName;
    private int lineNumber;
    private String userId;
    private String httpMethod;
    private String httpPath;

}