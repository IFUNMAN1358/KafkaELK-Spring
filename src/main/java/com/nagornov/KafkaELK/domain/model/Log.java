package com.nagornov.KafkaELK.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private HttpParams httpParams;
    private ExceptionParams exceptionParams;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class HttpParams {

        private String method;
        private String path;
        private int status;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ExceptionParams {

        private String type;
        private String message;
        private String stackTrace;

    }

    public void updateCurrentTimestamp() {
        this.timestamp = Instant.now();
    }

    public void updateContent(@NotNull String message, @NotNull String level) {
        this.message = message;
        this.level = level;
    }

    public void updateTraceMetadata(@NotNull String traceId, @NotNull String spanId) {
        this.traceId = traceId;
        this.spanId = spanId;
    }

    public void updateService(@NotNull String service) {
        this.service = service;
    }

    public void updateCallerMetadata(@NotNull StackTraceElement relevantElement) {
        this.file = relevantElement.getFileName();
        this.method = relevantElement.getMethodName();
        this.line = relevantElement.getLineNumber();
    }

    public void updateLayerName(@NotNull String layerName) {
        this.layerName = layerName;
    }

    public void updateUserId(@NotNull String userId) {
        this.userId = userId;
    }

    public void updateHttpParams(
            @NotNull String method,
            @NotNull String path,
            @NotNull int status
    ) {
        this.httpParams = new HttpParams(method, path, status);
    }

    public void setHttpParamsAsNull() {
        this.httpParams = null;
    }

    public void updateExceptionParams(
            @NotNull String type,
            @NotNull String message,
            @NotNull StackTraceElement[] stackTrace
    ) {
        this.exceptionParams = new ExceptionParams(type, message, stackTrace.toString());
    }

    public void setExceptionParamsAsNull() {
        this.exceptionParams = null;
    }

    @Override
    public String toString() {
        return "Log{" + '\n' +
                "timestamp=" + timestamp + '\n' +
                ", level='" + level + '\n' +
                ", message='" + message + '\n' +
                ", traceId='" + traceId + '\n' +
                ", spanId='" + spanId + '\n' +
                ", layer='" + layerName + '\n' +
                ", service='" + service + '\n' +
                ", file='" + file + '\n' +
                ", method='" + method + '\n' +
                ", line=" + line + '\n' +
                ", userId='" + userId + '\n' +
                ", httpParams=" + httpParams + '\n' +
                ", exceptionParams=" + exceptionParams + '\n' +
                '}';
    }
}