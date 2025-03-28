package com.example.api.model.dto.auth;

public record AuthRequestDto(
        String email,
        String password
) {
}
