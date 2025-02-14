package com.nagornov.KafkaELK.application.controller;

import com.nagornov.KafkaELK.application.dto.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LogController {

    @PostMapping(
            value = "/api/v1/log/send",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<MessageResponse> sendLog() {
        return ResponseEntity.status(
                201
        ).body(
                new MessageResponse("Success", 200)
        );
    }

}
