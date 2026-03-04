package org.example.banking.controller;

import org.example.banking.service.BankService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam int amount) {
        bankService.deposit(amount);
        return "Deposit successful";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam int amount) {
        bankService.withdraw(amount);
        return "Withdraw successful";
    }

    @GetMapping("/balance")
    public int balance() {
        return bankService.getBalance();
    }
}
