package com.nagornov.KafkaELK.infrastructure.configuration.properties.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "external-clients")
@Getter
@Setter
public class ExternalClientsProperties {

    private Postman postman;
    private CorporateMessenger CorporateMessenger;

    @Getter
    @Setter
    public static class Postman {

        private String serviceName;
        private String url;
        private String apiKey;

    }

    @Getter
    @Setter
    public static class CorporateMessenger {

        private String serviceName;
        private String url;
        private String apiKey;

    }

    private List<String> urls;
    private List<String> apiKeys;

}