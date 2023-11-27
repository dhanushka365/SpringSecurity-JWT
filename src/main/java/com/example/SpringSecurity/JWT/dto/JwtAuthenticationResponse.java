package com.example.SpringSecurity.JWT.dto;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String token;

    private String  refreshToken;
}
