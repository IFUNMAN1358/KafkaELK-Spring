package com.nagornov.KafkaELK.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LogHttp {

    private String method;
    private String path;
    private int status;

}
