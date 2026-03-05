package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthRequest;
import org.example.dto.AuthResponse;
import org.example.model.User;
import org.example.service.AuthService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public Mono<User> register(@RequestBody AuthRequest request) {
        System.out.println("REGISTER API CALLED");
        return authService.register(request);
    }


    @PostMapping("/login")
    public Mono<AuthResponse> login(@RequestBody AuthRequest request) {
        return authService.login(request)
                .map(AuthResponse::new);
    }
}
