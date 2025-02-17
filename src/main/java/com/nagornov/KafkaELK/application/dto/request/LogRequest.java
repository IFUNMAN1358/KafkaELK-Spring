package com.nagornov.KafkaELK.application.dto.request;

import com.nagornov.KafkaELK.sharedKernel.logs.model.Log;
import lombok.Data;

@Data
public class LogRequest {

    private Log log;

}
