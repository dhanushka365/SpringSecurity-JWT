package com.example.SpringSecurity.JWT.services.impl;

import com.example.SpringSecurity.JWT.dto.SignUpRequest;
import com.example.SpringSecurity.JWT.entities.Role;
import com.example.SpringSecurity.JWT.entities.User;
import com.example.SpringSecurity.JWT.repository.UserRepository;
import com.example.SpringSecurity.JWT.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User signup(SignUpRequest signUpRequest){

        User user = new User();

        user.setEmail(signUpRequest.getEmail());
        user.setFirstname(signUpRequest.getFirstName());
        user.setSecondname(signUpRequest.getLastName());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);
    }
}
