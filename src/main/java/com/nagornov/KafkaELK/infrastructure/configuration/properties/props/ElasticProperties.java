package com.nagornov.KafkaELK.infrastructure.configuration.properties.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.elasticsearch")
@Getter
@Setter
public class ElasticProperties {

    private String username;
    private String password;
    private String uris;

}
