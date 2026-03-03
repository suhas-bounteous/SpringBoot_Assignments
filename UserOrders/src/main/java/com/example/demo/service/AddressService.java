package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(Math.toIntExact(id));
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(Math.toIntExact(id));
    }
}
