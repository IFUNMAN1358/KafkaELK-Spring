package com.nagornov.KafkaELK.infrastructure.configuration.external.kafka;

import com.nagornov.KafkaELK.domain.enums.KafkaServiceTopic;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic defaultServiceTopic() {
        return new NewTopic(KafkaServiceTopic.DEFAULT_SERVICE_TOPIC.getTopicName(), 1, (short) 1);
    }

    @Bean
    public NewTopic logServiceTopic() {
        return new NewTopic(KafkaServiceTopic.LOG_SERVICE_TOPIC.getTopicName(), 1, (short) 1);
    }

    @Bean
    public NewTopic corporateMessengerServiceTopic() {
        return new NewTopic(KafkaServiceTopic.CORPORATE_MESSENGER_SERVICE_TOPIC.getTopicName(), 1, (short) 1);
    }

}
