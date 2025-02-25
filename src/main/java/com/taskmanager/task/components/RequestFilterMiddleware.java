package com.taskmanager.task.components;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestFilterMiddleware implements Filter {

    private final Environment env;

    public RequestFilterMiddleware(Environment env) {
        this.env = env;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;

        String apiKey = httpRequest.getHeader("x-api-key");
        String envKey = env.getProperty("app.api.key");

        if (envKey == null || !envKey.equals(apiKey)) {
            httpResponse.setStatus(HttpStatus.FORBIDDEN.value());
            httpResponse.setContentType("application/json");
            
            PrintWriter writer = httpResponse.getWriter();
            writer.write("{\"error\": \"Invalid API Key\", \"status\": 403}");
            writer.flush();
            return; // Stop the filter chain execution
        }
        chain.doFilter(req, res);
    }

}
