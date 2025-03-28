package com.example.api.controller;

import com.example.api.model.dto.auth.AuthResponseDto;
import com.example.api.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Funcionando!");
    }

    @PostMapping("/")
    public ResponseEntity<Void> authUser() {
        String url = authService.authUser(clientId, scope, redirectUri);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", url);

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }

    @GetMapping("/getCode")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponseDto getToken(@RequestParam("code") String code, HttpServletRequest request) {
        AuthResponseDto authResponse = authService.getToken(clientId, clientSecret, code);

        // Save manually the token of session
        request.getSession().setAttribute("ACCESS_TOKEN", authResponse.access_token());

        // Define the authenticated user on Spring Security scope
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(authResponse.access_token(), null, List.of(new SimpleGrantedAuthority("ROLE_USER")));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return authResponse;
    }
}
