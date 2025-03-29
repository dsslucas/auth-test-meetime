package com.example.api.controller;

import com.example.api.model.dto.auth.AuthResponseDto;
import com.example.api.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/auth")
public class AuthRestController {
    @Value("${app.api.client_id}")
    private String clientId;

    @Value("${app.api.redirect_uri}")
    private String redirectUri;

    @Value("${app.api.scope}")
    private String scope;

    @Value("${app.api.client_secret}")
    private String clientSecret;

    private final AuthService authService = new AuthService();

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String authUser() {
        return authService.authUser(clientId, scope, redirectUri);
    }

    @GetMapping("/getCode")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponseDto getToken(@RequestParam("code") @Validated String code, HttpServletRequest request) {
        return authService.getToken(clientId, clientSecret, code, request);
    }
}
