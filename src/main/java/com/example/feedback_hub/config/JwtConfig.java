package com.example.feedback_hub.config;

import com.example.feedback_hub.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@Configuration
public class JwtConfig {

    @Value("${app.jwt.secret}")
    private String jwtSecret;

    @Value("${app.jwt.expiration}")
    private int jwtExpirationInMs;

    private final JwtTokenProvider jwtTokenProvider;

    public JwtConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        jwtTokenProvider.init();
    }
} 