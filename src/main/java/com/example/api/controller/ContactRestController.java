package com.example.api.controller;

import com.example.api.model.dto.contact.PropertyContactDto;
import com.example.api.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
@Tag(name = "Contato | Contact", description = "API dedicada ao contato | API dedicated for contact")
@SecurityRequirement(name = "Bearer Authentication")
public class ContactRestController {
    private ContactService contactService = new ContactService();

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Criação de contato | Create contact", description = "Registro de contato na conta de teste de desenvolvedor | Contact register on development test account.")
    public String createContact(@RequestBody @Validated PropertyContactDto data){
        return contactService.createContact(data);
    }
}
