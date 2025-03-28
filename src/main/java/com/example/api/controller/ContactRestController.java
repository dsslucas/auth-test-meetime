package com.example.api.controller;

import com.example.api.model.dto.contact.PropertyContactDto;
import com.example.api.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactRestController {
//    @GetMapping("/")
//    @ResponseStatus(HttpStatus.OK)
//    public

    private ContactService contactService = new ContactService();

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String createContact(@RequestBody PropertyContactDto data){
        return contactService.createContact(data);
    }

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String test() {
        System.out.println("Usuário autenticado: " + SecurityContextHolder.getContext().getAuthentication());

        return "tudo certo";
    }
}
