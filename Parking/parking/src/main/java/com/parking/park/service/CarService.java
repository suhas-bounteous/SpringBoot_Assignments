package com.parking.park.service;

import com.parking.park.dto.Car;
import com.parking.park.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CarService {

    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public Map<Long, Car> getAllCars() {
        return repository.findAll();
    }

    public Car getCarById(Long id) {
        Car car = repository.findById(id);
        if (car == null) {
            throw new RuntimeException("Car not found with id: " + id);
        }
        return car;
    }

    public String addCar(Car car) {
        repository.save(car);
        return "Car added successfully";
    }

    public String deleteCar(Long id) {
        repository.delete(id);
        return "Car deleted successfully";
    }

    public String updateCar(Long id, Car car) {
        repository.save(car);
        return "Car updated successfully";
    }
}
