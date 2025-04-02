package com.example.oauth2_demo_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class AppConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // Configure XSRF Cookie handling
                .csrf(httpSecCsrfConfig -> httpSecCsrfConfig.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                // Http Request path matchers
                .authorizeHttpRequests(authMgrReqMatcherReg -> authMgrReqMatcherReg
                        // Allow without auth
                        .requestMatchers("/", "/index.html", "/login", "/error", "/webjars/**").permitAll()
                        // All other endpoints require auth
                        .anyRequest().authenticated())
                // Default OAuth handling
                .oauth2Login(Customizer.withDefaults())
                // Default logout functionality with successful redirect back to home page
                .logout(httpSecLogoutConfig -> httpSecLogoutConfig.logoutSuccessUrl("/").permitAll())
                .exceptionHandling(exHndling -> exHndling.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .build();
    }
}
