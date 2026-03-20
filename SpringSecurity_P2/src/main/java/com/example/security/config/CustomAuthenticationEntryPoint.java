package com.example.security.config;

import jakarta.servlet.http.*;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         org.springframework.security.core.AuthenticationException authException)
            throws IOException {

        response.setStatus(401);
        response.getWriter().write("Unauthorized");
    }
}
