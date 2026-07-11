package com.adityadarji.backend.service.impl;

import com.adityadarji.backend.entity.Car;
import com.adityadarji.backend.repository.CarRepository;
import com.adityadarji.backend.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Car updateCar(Long id, Car updatedCar) {
        Car existingCar = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        existingCar.setBrand(updatedCar.getBrand());
        existingCar.setModel(updatedCar.getModel());
        existingCar.setYear(updatedCar.getYear());
        existingCar.setColor(updatedCar.getColor());
        existingCar.setFuelType(updatedCar.getFuelType());
        existingCar.setTransmission(updatedCar.getTransmission());
        existingCar.setMileage(updatedCar.getMileage());
        existingCar.setPrice(updatedCar.getPrice());
        existingCar.setVin(updatedCar.getVin());
        existingCar.setStatus(updatedCar.getStatus());

        return carRepository.save(existingCar);
    }

    @Override
    public void deleteCar(Long id) {

        Car existingCar = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        carRepository.delete(existingCar);

    }
}