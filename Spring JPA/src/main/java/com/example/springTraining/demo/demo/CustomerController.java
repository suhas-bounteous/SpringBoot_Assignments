package com.example.springTraining.demo.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @PutMapping("/{id}/email")
    public Customer updateEmail(@PathVariable Long id,
                                @RequestParam String newEmail) {
        return service.updateEmail(id, newEmail);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }
}
