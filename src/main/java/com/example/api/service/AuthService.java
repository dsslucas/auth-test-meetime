package com.example.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    public String authUser(String clientId, String scope, String redirectUri){
        String AUTH_URL = "https://app.hubspot.com/oauth/authorize";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = AUTH_URL + "?client_id=" + clientId + "&scope=" + scope + "&redirect_uri=" + redirectUri;

        System.out.println(url);
        return url;
    }

    public String getToken(String code){
        System.out.println("token obtido: " + code);
        return code;
    }
}
