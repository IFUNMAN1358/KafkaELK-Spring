package com.nagornov.KafkaELK.infrastructure.configuration.security;

import com.nagornov.KafkaELK.infrastructure.security.filter.CustomCorsFilter;
import com.nagornov.KafkaELK.infrastructure.security.filter.CustomCsrfFilter;
import com.nagornov.KafkaELK.infrastructure.security.filter.CustomTraceFilter;
import com.nagornov.KafkaELK.infrastructure.security.handler.CustomAccessDeniedHandler;
import com.nagornov.KafkaELK.infrastructure.security.handler.CustomAuthenticationEntryPoint;
import com.nagornov.KafkaELK.infrastructure.security.manager.ExternalClientsAuthorizationManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final CustomCorsFilter corsFilter;
    private final CustomCsrfFilter csrfFilter;
    private final CustomTraceFilter traceFilter;

    private final ExternalClientsAuthorizationManager authExternalClient;

    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          http
            .httpBasic(AbstractHttpConfigurer::disable)
            .cors(AbstractHttpConfigurer::disable)
            .csrf(AbstractHttpConfigurer::disable)
            .headers(headers -> headers
                    .contentSecurityPolicy(csp -> csp
                            .policyDirectives("default-src 'self'; script-src 'self' 'unsafe-inline'; object-src 'none';")
                    )
                    .frameOptions(HeadersConfigurer.FrameOptionsConfig::deny)
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(corsFilter, ChannelProcessingFilter.class)
            .addFilterBefore(csrfFilter, UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(traceFilter, UsernamePasswordAuthenticationFilter.class)
            .authorizeHttpRequests(auth -> auth

                    .requestMatchers(HttpMethod.POST, "/api/v1/log/send").access(authExternalClient)

                    .anyRequest().authenticated()
            );
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
            .requestMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}