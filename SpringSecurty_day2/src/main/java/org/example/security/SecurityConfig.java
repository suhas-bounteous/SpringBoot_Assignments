package org.example.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtServerSecurityContextRepository securityContextRepository;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .securityContextRepository(securityContextRepository)
                .authorizeExchange(exchanges -> exchanges

                        .pathMatchers("/auth/**").permitAll()

                        .pathMatchers("/api/admin/**")
                        .hasRole("ADMIN")

                        .pathMatchers("/api/user/**")
                        .hasAnyRole("USER","ADMIN")

                        .anyExchange().authenticated()
                )
                .build();
    }
}
