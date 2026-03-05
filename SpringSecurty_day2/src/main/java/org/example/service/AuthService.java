package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthRequest;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Mono<User> register(AuthRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        return userRepository.save(user);
    }

    public Mono<String> login(AuthRequest request) {

        return userRepository.findByUsername(request.getUsername())
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")))
                .filter(user -> encoder.matches(request.getPassword(), user.getPassword()))
                .switchIfEmpty(Mono.error(new RuntimeException("Invalid password")))
                .map(user -> jwtUtil.generateToken(user.getUsername(), user.getRole()));
    }
}
