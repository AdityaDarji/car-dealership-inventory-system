package com.adityadarji.backend.dto;

import lombok.*;

import java.math.BigDecimal;

import com.adityadarji.backend.entity.Vehicle.VehicleStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDTO {

    private Long id;

    private String brand;

    private String model;

    private Integer year;

    private String color;

    private String fuelType;

    private String transmission;

    private Integer mileage;

    private BigDecimal price;

    private String category;

    private Integer quantity;
    private String imageUrl;

    private VehicleStatus status;

    // We are not adding createdAt, updatedAt and vin number here

}
