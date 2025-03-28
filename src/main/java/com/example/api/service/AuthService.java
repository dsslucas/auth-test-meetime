package com.example.api.service;

import com.example.api.model.dto.AuthResponseDto;
import com.example.api.model.dto.TokenRequestBodyDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    public String authUser(String clientId, String scope, String redirectUri){
        String AUTH_URL = "https://app.hubspot.com/oauth/authorize";
        String url = AUTH_URL + "?client_id=" + clientId + "&scope=" + scope + "&redirect_uri=" + redirectUri;
        System.out.println(url);
        return url;
    }

    public AuthResponseDto getToken(String clientId, String clientSecret, String code){
        System.out.println("codigo obtido: " + code);

        String url = "https://api.hubapi.com/oauth/v1/token";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        TokenRequestBodyDto body = new TokenRequestBodyDto(
                "authorization_code",
                clientId,
                clientSecret,
                "http://localhost:8080/api/auth/getCode",
                code
        );

        HttpEntity<TokenRequestBodyDto> requestEntity = new HttpEntity<>(body, headers);

        return new AuthResponseDto("bearer", "oi", 12, "aaaaaaaaaaaaa");
    }
}
