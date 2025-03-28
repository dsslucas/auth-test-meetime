package com.example.api.model.dto;

public record TokenRequestBodyDto(
        String grant_type,
        String client_id,
        String client_secret,
        String redirect_uri,
        String code
) {
}
