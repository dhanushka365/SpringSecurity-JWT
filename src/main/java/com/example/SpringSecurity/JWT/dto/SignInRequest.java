package com.example.SpringSecurity.JWT.dto;

import lombok.Data;

@Data
public class SignInRequest {

    private String email;
    private String password;
}
