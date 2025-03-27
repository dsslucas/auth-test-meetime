package com.example.api.model.dto;

public record AuthRequestDto(
        String email,
        String password
) {
}
