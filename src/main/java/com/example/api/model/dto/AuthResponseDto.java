package com.example.api.model.dto;

public record AuthResponseDto(
        String token_type,
        String refresh_token,
        Integer expires_in,
        String access_token
) {
}
