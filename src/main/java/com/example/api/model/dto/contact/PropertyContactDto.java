package com.example.api.model.dto.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PropertyContactDto(
        @Email(message = "Invalid e-mail.")
        @NotBlank(message = "Email not informed.")
        String email,

        @NotBlank(message = "Firstname not informed.")
        String firstname,

        @NotBlank(message = "Lastname not informed.")
        String lastname
) {
}
