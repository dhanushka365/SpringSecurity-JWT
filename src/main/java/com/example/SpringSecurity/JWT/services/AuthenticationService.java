package com.example.SpringSecurity.JWT.services;

import com.example.SpringSecurity.JWT.dto.JwtAuthenticationResponse;
import com.example.SpringSecurity.JWT.dto.RefreshTokenRequest;
import com.example.SpringSecurity.JWT.dto.SignInRequest;
import com.example.SpringSecurity.JWT.dto.SignUpRequest;
import com.example.SpringSecurity.JWT.entities.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
