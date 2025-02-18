package com.nagornov.KafkaELK.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HttpResponse {

    private String message;
    private int status;

}
