package com.example.auth_service.controller;

import com.example.auth_service.dto.LoginRequest;
import com.example.auth_service.security.JwtUtil;
import com.example.auth_service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthService auth_service;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){

        boolean valid = auth_service.validateUser(
                request.getUsername(),
                request.getPassword()
        );

        if(!valid)
            throw new RuntimeException("Invalid credentials");

        String role = auth_service.getRole(request.getUsername());

        return jwtUtil.generateToken(
                request.getUsername(),
                role
        );
    }

}
