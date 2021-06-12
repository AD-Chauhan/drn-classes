package com.online.videostreaming.classrooms.onlineclassrooms.csrf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.csrf.CsrfTokenRepository;

import com.online.videostreaming.classrooms.onlineclassrooms.csrf.repository.HttpSessionCsrfTokenRepository;
import com.online.videostreaming.classrooms.onlineclassrooms.csrf.service.CsrfSecretService;

@Configuration
public class CSRFConfig {

    @Autowired
    CsrfSecretService secretService;

    @Bean
    @ConditionalOnMissingBean
    public CsrfTokenRepository jwtCsrfTokenRepository() {
        return new HttpSessionCsrfTokenRepository(secretService.getHS256SecretBytes());
    }
}