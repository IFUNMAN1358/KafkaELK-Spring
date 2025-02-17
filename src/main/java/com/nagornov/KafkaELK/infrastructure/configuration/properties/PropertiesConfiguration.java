package com.nagornov.KafkaELK.infrastructure.configuration.properties;

import com.nagornov.KafkaELK.infrastructure.configuration.properties.props.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
    ServiceProperties.class,
    KafkaProperties.class,
    ElasticProperties.class,
    LogstashClientUdpProperties.class,
    LogstashClientTcpProperties.class,
    LogstashClientHttpProperties.class,
    ExternalClientsProperties.class,
    CsrfProperties.class
})
public class PropertiesConfiguration {
}
