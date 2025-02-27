package com.nagornov.KafkaELK.infrastructure.security.filter;

import com.nagornov.KafkaELK.infrastructure.configuration.properties.props.ExternalClientsProperties;
import com.nagornov.KafkaELK.infrastructure.configuration.properties.props.ServiceProperties;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomCorsFilter extends GenericFilterBean {

    private final ServiceProperties serviceProperties;
    private final ExternalClientsProperties externalClientsProperties;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String origin = request.getHeader("Origin");
        String allowedOriginValue = null;

        if (origin != null && externalClientsProperties.getUrls().contains(origin)) {
            allowedOriginValue = origin;
        } else {
            allowedOriginValue = serviceProperties.getClientUrl();
        }

        response.setHeader("Access-Control-Allow-Origin", allowedOriginValue);
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,PATCH,OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Xsrf-Token,X-Trace-Id,X-Api-Key");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        fc.doFilter(servletRequest, response);

    }

}