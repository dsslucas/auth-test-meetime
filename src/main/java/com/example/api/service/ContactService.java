package com.example.api.service;

import com.example.api.exceptions.ConflictException;
import com.example.api.model.dto.contact.CreateContactRequestDto;
import com.example.api.model.dto.contact.PropertyContactDto;
import jakarta.persistence.PersistenceException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ContactService {

    private final AuthService authService = new AuthService();

    public String createContact(PropertyContactDto data){
        try {

            CreateContactRequestDto body = new CreateContactRequestDto(data);
            String url = "https://api.hubapi.com/crm/v3/objects/contacts";
            String token = authService.getToken();

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(token);

            HttpEntity<CreateContactRequestDto> requestEntity = new HttpEntity<>(body, headers);
            ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class);
            return "User created!";
        } catch (HttpClientErrorException.Conflict ex) {
            System.err.println("Conflict error (409): " + ex.getResponseBodyAsString());
            throw new ConflictException("Conflict: Contact already exists.");
        } catch (HttpClientErrorException ex) {
            System.err.println("HTTP error: " + ex.getStatusCode() + " - " + ex.getResponseBodyAsString());
            throw new RuntimeException("HTTP error: " + ex.getStatusCode());
        } catch (RestClientException ex) {
            System.err.println("Request error: " + ex.getMessage());
            throw new RuntimeException("Error while creating new contact.");
        }
    }
}
