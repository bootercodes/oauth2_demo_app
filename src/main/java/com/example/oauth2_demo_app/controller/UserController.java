package com.example.oauth2_demo_app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping
@Slf4j
public class UserController {
    @GetMapping("/user")
    public Map<String, String> user(@AuthenticationPrincipal OAuth2User principal) {
        log.info("Authenticated Principal - {}", principal);
        return Collections.singletonMap("name", principal.getName());
    }
}
