package com.nagornov.KafkaELK.infrastructure.security.filter;

import com.nagornov.KafkaELK.infrastructure.configuration.properties.props.CsrfProperties;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class CustomCsrfFilter extends GenericFilterBean {

    private final CsrfProperties csrfProperties;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        CsrfToken csrfToken = csrfTokenRepository().loadToken(request);

        if (csrfToken == null) {
            csrfToken = csrfTokenRepository().generateToken(request);
            csrfTokenRepository().saveToken(csrfToken, request, response);
        }

        String csrfTokenFromCookie = getCsrfTokenFromCookie(request);

        if (csrfTokenFromCookie == null || !csrfTokenFromCookie.equals(csrfToken.getToken())) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "CSRF token missing or incorrect.");
            return;
        }
        fc.doFilter(request, response);
    }

    private CookieCsrfTokenRepository csrfTokenRepository() {
        CookieCsrfTokenRepository repository = new CookieCsrfTokenRepository();

        repository.setHeaderName(csrfProperties.getHeaderName());
        repository.setCookieName(csrfProperties.getCookie().getName());

        repository.setCookieCustomizer(cookieBuilder ->
            cookieBuilder
                .domain(csrfProperties.getCookie().getDomain())
                .path(csrfProperties.getCookie().getPath())
                .httpOnly(csrfProperties.getCookie().isHttpOnly())
                .secure(csrfProperties.getCookie().isSecure())
                .sameSite(csrfProperties.getCookie().getSameSite())
        );
        return repository;
    }

    private String getCsrfTokenFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (csrfProperties.getCookie().getName().equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}