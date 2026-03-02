package com.parking.park.dto;

public class Car {

    private long id;
    private String brand;
    private String carName;

    // REQUIRED by Spring
    public Car() {}

    public Car(long id, String brand, String carName){
        this.id=id;
        this.brand=brand;
        this.carName=carName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
