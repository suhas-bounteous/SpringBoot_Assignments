package com.example.api_gateway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String SECRET =
            "myveryveryveryveryveryverysecurejwtsecretkey1234567890";

    public boolean validateToken(String token){

        try {

            Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token);

            return true;

        } catch(Exception e) {
            return false;
        }

    }

    public String extractRole(String token){

        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.get("role", String.class);
    }

}
