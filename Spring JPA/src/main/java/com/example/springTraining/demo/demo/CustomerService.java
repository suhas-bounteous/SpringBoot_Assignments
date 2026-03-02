package com.example.springTraining.demo.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer createCustomer(Customer customer) {
        if (repository.existsByEmail(customer.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return repository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Transactional
    public Customer updateEmail(Long id, String newEmail) {

        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (repository.existsByEmail(newEmail)) {
            throw new RuntimeException("Email already exists");
        }

        customer.setEmail(newEmail);

        // No need to call save() explicitly
        // Because JPA dirty checking will update it automatically
        // when transaction commits

        return customer;
    }

    @Transactional
    public void deleteCustomer(Long id) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        repository.delete(customer);
    }
}
