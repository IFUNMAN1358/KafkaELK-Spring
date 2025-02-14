package com.nagornov.KafkaELK.application.advice;

import com.nagornov.KafkaELK.domain.logger.AdviceLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final AdviceLogger adviceLogger;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        adviceLogger.error("Unhandled exception: " + e.getMessage());
        return ResponseEntity.status(500).body("Internal Server Error");
    }

}