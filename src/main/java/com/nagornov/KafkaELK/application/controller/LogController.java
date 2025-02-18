package com.nagornov.KafkaELK.application.controller;

import com.nagornov.KafkaELK.application.applicationService.LogApplicationService;
import com.nagornov.KafkaELK.application.dto.request.LogRequest;
import com.nagornov.KafkaELK.application.dto.response.HttpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LogController {

    private final LogApplicationService logApplicationService;

    @PostMapping(
            value = "/api/v1/log/send",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<HttpResponse> sendLog(@RequestBody LogRequest request) {
        HttpResponse response = logApplicationService.sendLog(request);
        return ResponseEntity.status(201).body(response);
    }

}
