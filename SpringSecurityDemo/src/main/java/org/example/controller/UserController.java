package org.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String userAccess() {
        return "Hello User!";
    }
}
