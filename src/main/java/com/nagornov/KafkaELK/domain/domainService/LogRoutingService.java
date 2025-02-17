package com.nagornov.KafkaELK.domain.domainService;

import com.nagornov.KafkaELK.domain.enums.KafkaServiceTopic;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LogRoutingService {

    @Value("${external-clients.postman.service-name}")
    private String postmanServiceName;

    @Value("${external-clients.corporate-messenger.service-name}")
    private String corporateMessengerServiceName;

    private Map<String, KafkaServiceTopic> serviceTopics;

    @PostConstruct
    public void init() {
        this.serviceTopics = Map.of(
            postmanServiceName, KafkaServiceTopic.DEFAULT_SERVICE_TOPIC,
            corporateMessengerServiceName, KafkaServiceTopic.CORPORATE_MESSENGER_SERVICE_TOPIC
        );
    }

    public KafkaServiceTopic getServiceTopic(String serviceName) {
        return this.serviceTopics.getOrDefault(serviceName, KafkaServiceTopic.DEFAULT_SERVICE_TOPIC);
    }

}
