package com.parking.park.controller;

import com.parking.park.dto.Car;
import com.parking.park.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cars")
public class CarName {

    private final CarService service;

    public CarName(CarService service) {
        this.service = service;
    }

    @GetMapping
    public Map<Long, Car> getAllCars() {
        return service.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) {
        return service.getCarById(id);
    }

    @PostMapping
    public String addCar(@RequestBody Car car) {
        return service.addCar(car);
    }

    @PutMapping("/{id}")
    public String updateCar(@PathVariable Long id, @RequestBody Car car) {
        return service.updateCar(id, car);
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable Long id) {
        return service.deleteCar(id);
    }
}
