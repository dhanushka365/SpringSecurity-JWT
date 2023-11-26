package com.example.SpringSecurity.JWT.services;

import com.example.SpringSecurity.JWT.dto.SignUpRequest;
import com.example.SpringSecurity.JWT.entities.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);
}
