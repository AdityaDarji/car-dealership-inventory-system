package com.adityadarji.backend.service;

import com.adityadarji.backend.entity.Car;

import java.util.List;

public interface CarService {

    Car createCar(Car car);

    List<Car> getAllCars();

    Car getCarById(Long id);

    Car updateCar(Long id, Car car);

    void deleteCar(Long id);

}