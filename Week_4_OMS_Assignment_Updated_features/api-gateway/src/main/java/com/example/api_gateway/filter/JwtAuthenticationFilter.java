package com.example.api_gateway.filter;

import com.example.api_gateway.security.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
public class JwtAuthenticationFilter implements GlobalFilter, Ordered {

    private final String SECRET =
            "myveryveryveryveryveryverysecurejwtsecretkey1234567890";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();

        // Allow login endpoint
        if (request.getURI().getPath().contains("/auth/login")) {
            return chain.filter(exchange);
        }

        if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {

            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String token = request.getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION)
                .replace("Bearer ", "");

        try {

            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();

            String role = claims.get("role", String.class);

            ServerHttpRequest modifiedRequest = exchange.getRequest()
                    .mutate()
                    .header("X-Role", role)
                    .build();

            ServerWebExchange modifiedExchange =
                    exchange.mutate().request(modifiedRequest).build();
            return chain.filter(modifiedExchange);


        } catch (Exception e) {

            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

    }

    @Override
    public int getOrder() {
        return -1;
    }
}
