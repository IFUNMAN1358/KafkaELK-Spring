package com.nagornov.KafkaELK.infrastructure.security.manager;

import com.nagornov.KafkaELK.infrastructure.configuration.properties.props.ExternalClientsProperties;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

import java.util.function.Supplier;

@Configuration
@RequiredArgsConstructor
public class ExternalClientsAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    private final ExternalClientsProperties externalClientsProperties;

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        HttpServletRequest request = object.getRequest();

        String apiKeyHeader = request.getHeader("X-Api-Key");

        if (apiKeyHeader != null && externalClientsProperties.getApiKeys().contains(apiKeyHeader)) {
            return new AuthorizationDecision(true);
        }

        return new AuthorizationDecision(false);
    }

    @Override
    public void verify(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        AuthorizationDecision decision = check(authentication, object);
        if (!decision.isGranted()) {
            throw new org.springframework.security.access.AccessDeniedException("Error receiving request from external client");
        }
    }

}