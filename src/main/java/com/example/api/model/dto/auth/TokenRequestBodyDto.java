package com.example.api.model.dto.auth;

public record TokenRequestBodyDto(
        String grant_type,
        String client_id,
        String client_secret,
        String redirect_uri,
        String code
) {
}
