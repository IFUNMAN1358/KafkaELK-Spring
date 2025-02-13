package com.nagornov.KafkaELK.domain.core;


public class LogContextHolder {

    private static final ThreadLocal<String> TRACE_ID = new ThreadLocal<>();
    private static final ThreadLocal<String> SPAN_ID = new ThreadLocal<>();
    private static final ThreadLocal<String> USER_ID = new ThreadLocal<>();

    public static String getTraceId() {
        return TRACE_ID.get();
    }

    public static String getSpanId() {
        return SPAN_ID.get();
    }

    public static String getUserId() {
        return USER_ID.get();
    }

    public static void setTraceId(String traceId) {
        TRACE_ID.set(traceId);
    }

    public static void setSpanId(String spanId) {
        SPAN_ID.set(spanId);
    }

    public static void setUserId(String userId) {
        USER_ID.set(userId);
    }

    public static void clear() {
        TRACE_ID.remove();
        SPAN_ID.remove();
        USER_ID.remove();
    }
}