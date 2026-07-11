package com.adityadarji.backend.service;

import com.adityadarji.backend.dto.VehicleDTO;
import com.adityadarji.backend.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle createVehicle(Vehicle vehicle);

    List<VehicleDTO> getAllVehicle();

    Vehicle getVehicleById(Long id);

    Vehicle updateVehicle(Long id, Vehicle car);

    void deleteVehicle(Long id);

    VehicleDTO purchaseVehicle(Long id);

}