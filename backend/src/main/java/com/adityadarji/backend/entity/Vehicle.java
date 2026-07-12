package com.adityadarji.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    public enum VehicleStatus {
        AVAILABLE,
        RESERVED,
        SOLD,
        OUT_OF_STOCK
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Brand is required")
    @Column(nullable = false)
    private String brand;

    @NotBlank(message = "Model is required")
    @Column(nullable = false)
    private String model;

    @NotNull(message = "Year is required")
    @Positive(message = "Year must be positive")
    private Integer year;

    @NotBlank(message = "Color is required")
    private String color;

    @NotBlank(message = "Fuel type is required")
    private String fuelType;

    @Column(length = 1000, name = "image_url")
    @NotBlank(message = "Image is required")
    private String imageUrl;

    @NotBlank(message = "Transmission is required")
    private String transmission;

    @NotNull(message = "Milage is required")
    @Positive(message = "Milage must be greater tahn zero")
    private Integer mileage;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    private BigDecimal price;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer quantity;

    @Column(unique = true)
    @NotBlank(message = "VIN number is required")
    private String vin;

    @NotNull(message = "Status is required")
    @Enumerated(EnumType.STRING)
    private VehicleStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
