package com.nagornov.KafkaELK.application.applicationService;

import com.nagornov.KafkaELK.application.dto.request.LogRequest;
import com.nagornov.KafkaELK.application.dto.response.HttpResponse;
import com.nagornov.KafkaELK.domain.domainService.KafkaLogProducerService;
import com.nagornov.KafkaELK.domain.domainService.LogRoutingService;
import com.nagornov.KafkaELK.domain.enums.KafkaServiceTopic;
import com.nagornov.KafkaELK.sharedKernel.logs.model.Log;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogApplicationService {

    private final LogRoutingService logRoutingService;
    private final KafkaLogProducerService kafkaLogProducerService;


    public HttpResponse sendLog(@NotNull LogRequest request) {

        Log log = request.getLog();
        String serviceName = log.getServiceName();

        KafkaServiceTopic kafkaTopic = logRoutingService.getServiceTopic(serviceName);
        kafkaLogProducerService.sendMessage(kafkaTopic, log);

        return new HttpResponse("Log has been saved", 201);
    }

}
