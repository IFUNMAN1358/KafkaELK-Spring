package com.nagornov.KafkaELK.infrastructure.configuration.properties.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "logstash.client.http")
@Getter
@Setter
public class LogstashClientHttpProperties {

    private String host;
    private Integer port;
    private String url;
    private String username;
    private String password;

}