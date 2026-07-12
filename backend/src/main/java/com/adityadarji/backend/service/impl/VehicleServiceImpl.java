package com.adityadarji.backend.service.impl;

import com.adityadarji.backend.dto.VehicleDTO;
import com.adityadarji.backend.entity.Vehicle;
import com.adityadarji.backend.exception.OutOfStockException;
import com.adityadarji.backend.exception.VehicleNotFoundException;
import com.adityadarji.backend.mapper.VehicleMapper;
import com.adityadarji.backend.repository.VehicleRepository;
import com.adityadarji.backend.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle createVehicle(Vehicle car) {
        return vehicleRepository.save(car);
    }

    @Override
    public List<VehicleDTO> getAllVehicle() {
        return vehicleRepository.findAll()
                .stream()
                .map(VehicleMapper::toDTO)
                .toList();
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Car with ID" + id + "Not found"));
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        Vehicle existingCar = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Car with ID" + id + "Not found"));

        existingCar.setBrand(updatedVehicle.getBrand());
        existingCar.setModel(updatedVehicle.getModel());
        existingCar.setYear(updatedVehicle.getYear());
        existingCar.setColor(updatedVehicle.getColor());
        existingCar.setFuelType(updatedVehicle.getFuelType());
        existingCar.setTransmission(updatedVehicle.getTransmission());
        existingCar.setMileage(updatedVehicle.getMileage());
        existingCar.setPrice(updatedVehicle.getPrice());
        existingCar.setVin(updatedVehicle.getVin());
        existingCar.setStatus(updatedVehicle.getStatus());

        return vehicleRepository.save(existingCar);
    }

    @Override
    public void deleteVehicle(Long id) {

        Vehicle existingCar = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Car with ID" + id + "Not found"));

        vehicleRepository.delete(existingCar);

    }

    @Override
    public VehicleDTO purchaseVehicle(Long id) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(
                        "Vehicle not found"));

        if (vehicle.getQuantity() <= 0) {

            throw new OutOfStockException(
                    "Vehicle is out of stock");
        }

        vehicle.setQuantity(vehicle.getQuantity() - 1);

        Vehicle updatedVehicle = vehicleRepository.save(vehicle);

        return VehicleMapper.toDTO(updatedVehicle);
    }

    @Override
    public VehicleDTO restockVehicle(Long id,
            Integer quantity) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(
                        "Vehicle not found"));

        vehicle.setQuantity(
                vehicle.getQuantity() + quantity);

        Vehicle updated = vehicleRepository.save(vehicle);

        return VehicleMapper.toDTO(updated);
    }

    @Override
    public List<VehicleDTO> searchVehicles(
            String brand,
            String model,
            String category,
            Double minPrice,
            Double maxPrice) {

        if (brand != null) {
            return vehicleRepository
                    .findByBrandContainingIgnoreCase(brand)
                    .stream()
                    .map(VehicleMapper::toDTO)
                    .toList();
        }

        if (model != null) {
            return vehicleRepository
                    .findByModelContainingIgnoreCase(model)
                    .stream()
                    .map(VehicleMapper::toDTO)
                    .toList();
        }

        if (category != null) {
            return vehicleRepository
                    .findByCategoryContainingIgnoreCase(category)
                    .stream()
                    .map(VehicleMapper::toDTO)
                    .toList();
        }

        if (minPrice != null && maxPrice != null) {
            return vehicleRepository
                    .findByPriceBetween(minPrice, maxPrice)
                    .stream()
                    .map(VehicleMapper::toDTO)
                    .toList();
        }
        return getAllVehicle();
    }
}