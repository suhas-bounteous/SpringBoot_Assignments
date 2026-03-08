package com.example.auth_service.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean validateUser(String username, String password) {

        if(username.equals("admin") && password.equals("admin123"))
            return true;

        if(username.equals("trader") && password.equals("trader123"))
            return true;

        if(username.equals("viewer") && password.equals("viewer123"))
            return true;

        return false;
    }

    public String getRole(String username){

        if(username.equals("admin"))
            return "ADMIN";

        if(username.equals("trader"))
            return "TRADER";

        return "VIEWER";
    }

}
