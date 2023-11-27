package com.example.SpringSecurity.JWT.dto;

import lombok.Data;

@Data
public class RefreshTokenRequest {
    private String token;
}
