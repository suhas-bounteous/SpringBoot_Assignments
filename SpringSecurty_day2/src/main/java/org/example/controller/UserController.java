package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/user/profile")
    public Mono<String> profile() {
        return Mono.just("User profile accessed");
    }

    @GetMapping("/admin/users")
    public Flux<User> allUsers() {
        return userRepository.findAll();
    }
}
