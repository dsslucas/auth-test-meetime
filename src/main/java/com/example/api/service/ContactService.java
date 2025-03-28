package com.example.api.service;

import com.example.api.model.dto.contact.CreateContactRequestDto;
import com.example.api.model.dto.contact.PropertyContactDto;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final AuthService authService = new AuthService();

    public String createContact(PropertyContactDto data){
        CreateContactRequestDto requestBody = new CreateContactRequestDto(data);

        String token = authService.getToken();

        return "User created";
    }
}
