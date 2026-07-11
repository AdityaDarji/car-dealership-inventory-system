package com.adityadarji.backend.mapper;

import com.adityadarji.backend.dto.VehicleDTO;
import com.adityadarji.backend.entity.Vehicle;

public class VehicleMapper {

    public static VehicleDTO toDTO(Vehicle vehicle) {

        return VehicleDTO.builder()
                .id(vehicle.getId())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .year(vehicle.getYear())
                .color(vehicle.getColor())
                .fuelType(vehicle.getFuelType())
                .transmission(vehicle.getTransmission())
                .mileage(vehicle.getMileage())
                .price(vehicle.getPrice())
                .category(vehicle.getCategory())
                .quantity(vehicle.getQuantity())
                .status(vehicle.getStatus())
                .build();
    }

    public static Vehicle toEntity(VehicleDTO dto) {

        return Vehicle.builder()
                .id(dto.getId())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .year(dto.getYear())
                .color(dto.getColor())
                .fuelType(dto.getFuelType())
                .transmission(dto.getTransmission())
                .mileage(dto.getMileage())
                .price(dto.getPrice())
                .category(dto.getCategory())
                .quantity(dto.getQuantity())
                .status(dto.getStatus())
                .build();
    }

}
