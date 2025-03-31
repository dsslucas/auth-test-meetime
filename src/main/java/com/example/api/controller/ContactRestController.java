package com.example.api.controller;

import com.example.api.model.dto.contact.PropertyContactDto;
import com.example.api.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactRestController {
    private ContactService contactService = new ContactService();

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String createContact(@RequestBody @Validated PropertyContactDto data){
        return contactService.createContact(data);
    }

    @PostMapping(value = "/webhook", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void receiveWebhook(@RequestBody Object webhookNotificationPayload) {
        System.out.println("Webhook Notification Received: {}" + webhookNotificationPayload);
    }
}
