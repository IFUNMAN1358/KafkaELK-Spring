package com.nagornov.KafkaELK.application.controller;

import com.nagornov.KafkaELK.application.applicationService.TestApplicationService;
import com.nagornov.KafkaELK.domain.logger.ControllerLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestApplicationService testApplicationService;
    private final ControllerLogger controllerLogger;

    @GetMapping(
            value = "/api/test/first",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<String> firstTest() {
        controllerLogger.info("Method firstTest from TestController is init");
        String response = testApplicationService.someMethod();
        return ResponseEntity.status(200).body(response);
    }

}
