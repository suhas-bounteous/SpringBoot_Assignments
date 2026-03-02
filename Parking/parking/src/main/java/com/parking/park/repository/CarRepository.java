package com.parking.park.repository;

import com.parking.park.dto.Car;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CarRepository {

    private final Map<Long, Car> carMap = new HashMap<>();

    public Map<Long, Car> findAll() {
        return carMap;
    }

    public Car findById(Long id) {
        return carMap.get(id);
    }

    public void save(Car car) {
        carMap.put(car.getId(), car);
    }

    public void delete(Long id) {
        carMap.remove(id);
    }
}
