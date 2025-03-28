package com.example.api.service;

import com.example.api.model.dto.auth.AuthResponseDto;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {
    public String authUser(String clientId, String scope, String redirectUri){
        String AUTH_URL = "https://app.hubspot.com/oauth/authorize";
        String url = AUTH_URL + "?client_id=" + clientId + "&scope=" + scope + "&redirect_uri=" + redirectUri;
        System.out.println(url);
        return url;
    }

    public AuthResponseDto getToken(String clientId, String clientSecret, String code){
        String url = "https://api.hubapi.com/oauth/v1/token";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String body = "grant_type=authorization_code" +
                "&client_id=" + clientId +
                "&client_secret=" + clientSecret +
                "&redirect_uri=" + "http%3A%2F%2Flocalhost%3A8080%2Fapi%2Fauth%2FgetCode" +
                "&code=" + code;

        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<AuthResponseDto> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, AuthResponseDto.class);

        return response.getBody();
    }
}
