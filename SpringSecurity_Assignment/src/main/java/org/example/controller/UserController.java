package org.example.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/all")
    public String allUsers() {
        return "ADMIN can see all users";
    }

    @GetMapping("/employees")
    public String employees() {
        return "MANAGER or ADMIN can see employees";
    }

    @GetMapping("/manager")
    public String manager() {
        return "MANAGER or ADMIN can see manager details";
    }

    @GetMapping("/hr")
    public String hr() {
        return "HR can see only HR details";
    }

    @GetMapping("/debug")
    public String debug() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "Logged in user: " + auth.getName() + " Roles: " + auth.getAuthorities();
    }
}
