package com.example.api.service;

import com.example.api.model.dto.contact.CreateContactRequestDto;
import com.example.api.model.dto.contact.PropertyContactDto;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    public String createContact(PropertyContactDto data){
        CreateContactRequestDto requestBody = new CreateContactRequestDto(data);
        return "User created";
    }
}
