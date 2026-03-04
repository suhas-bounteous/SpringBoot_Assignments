package org.example.banking.service;

import org.example.banking.annotation.TrackExecution;
import org.example.banking.annotation.TrackExecution;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    private int balance = 1000;

    @TrackExecution
    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @TrackExecution
    public void withdraw(int amount) {
        if (amount > balance) {
            throw new RuntimeException("Insufficient balance");
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    public int getBalance() {
        return balance;
    }
}
