package com.nagornov.KafkaELK.infrastructure.configuration.external.kafka.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagornov.KafkaELK.domain.model.Log;
import com.nagornov.KafkaELK.infrastructure.configuration.properties.props.KafkaProperties;
import com.nagornov.KafkaELK.infrastructure.persistence.kafka.transfer.serializer.KafkaLogSerializer;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaLogServiceProducer {

    private final KafkaProperties kafkaProperties;
    private final ObjectMapper objectMapper;

    @Bean
    public KafkaTemplate<String, Log> kafkaLogServiceTemplate() {
        return new KafkaTemplate<>(kafkaLogServiceProducerFactory());
    }

    @Bean
    public ProducerFactory<String, Log> kafkaLogServiceProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configProps.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 1000);
        configProps.put(ProducerConfig.RETRIES_CONFIG, 0);

        return new DefaultKafkaProducerFactory<>(
                configProps,
                new StringSerializer(),
                new KafkaLogSerializer(objectMapper)
        );
    }

}
