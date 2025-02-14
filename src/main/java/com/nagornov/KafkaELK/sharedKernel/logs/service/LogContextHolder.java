package com.nagornov.KafkaELK.sharedKernel.logs.service;


import com.nagornov.KafkaELK.sharedKernel.logs.model.LogContext;

public class LogContextHolder {

    private static final ThreadLocal<LogContext> LOG_CONTEXT = ThreadLocal.withInitial(LogContext::new);

    public static String getTraceId() {
        return LOG_CONTEXT.get().getTraceId();
    }

    public static String getSpanId() {
        return LOG_CONTEXT.get().getSpanId();
    }

    public static String getUserId() {
        return LOG_CONTEXT.get().getUserId();
    }

    public static String getHttpMethod() {
        return LOG_CONTEXT.get().getHttpMethod();
    }

    public static String getHttpPath() {
        return LOG_CONTEXT.get().getHttpPath();
    }

    public static void setTraceId(String traceId) {
        LOG_CONTEXT.get().setTraceId(traceId);
    }

    public static void setSpanId(String spanId) {
        LOG_CONTEXT.get().setSpanId(spanId);
    }

    public static void setUserId(String userId) {
        LOG_CONTEXT.get().setUserId(userId);
    }

    public static void setHttpMethod(String httpMethod) {
        LOG_CONTEXT.get().setHttpMethod(httpMethod);
    }

    public static void setHttpPath(String httpPath) {
        LOG_CONTEXT.get().setHttpPath(httpPath);
    }

    public static void clear() {
        LOG_CONTEXT.remove();
    }
}