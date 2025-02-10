package com.nagornov.KafkaELK.domain.enums;

import lombok.Getter;

@Getter
public enum KafkaServiceTopic {

    LOG_SERVICE_TOPIC("log-service-topic"),
    CORPORATE_MESSENGER_SERVICE_TOPIC("corporate-messenger-service-topic");

    private final String topicName;

    KafkaServiceTopic(String topicName) {
        this.topicName = topicName;
    }

}
