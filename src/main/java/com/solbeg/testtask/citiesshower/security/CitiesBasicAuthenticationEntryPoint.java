package com.solbeg.testtask.citiesshower.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solbeg.testtask.citiesshower.model.Message;
import com.solbeg.testtask.citiesshower.service.ErrorHandler;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CitiesBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    private ErrorHandler errorHandler;
    private ObjectMapper objectMapper;

    public CitiesBasicAuthenticationEntryPoint(ErrorHandler errorHandler, ObjectMapper objectMapper) {
        this.errorHandler = errorHandler;
        this.objectMapper = objectMapper;
    }


    @Override
    public void commence(
            HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
            throws IOException {
        response.addHeader("WWW-Authenticate", "Basic realm = " + getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        String errorResponse = objectMapper.writeValueAsString(errorHandler
                .createErrorMessage(1, authEx.getMessage(), new Message()));
        response.getWriter().write(errorResponse);
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("Solbeg");
        super.afterPropertiesSet();
    }
}
