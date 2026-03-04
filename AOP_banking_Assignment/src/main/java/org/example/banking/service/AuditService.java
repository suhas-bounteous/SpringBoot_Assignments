package org.example.banking.service;

import org.springframework.stereotype.Service;

@Service
public class AuditService {

    public void audit(String message) {
        System.out.println("Audit Log: " + message);
    }
}
