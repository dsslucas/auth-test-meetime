package com.example.api.model.dto.auth;

public record AuthResponseDto(
        String token_type,
        String refresh_token,
        Integer expires_in,
        String access_token
) {
}
