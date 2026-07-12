package com.adityadarji.backend.repository;

import com.adityadarji.backend.entity.Vehicle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByBrandContainingIgnoreCase(String brand);

    List<Vehicle> findByModelContainingIgnoreCase(String model);

    List<Vehicle> findByCategoryContainingIgnoreCase(String category);

    List<Vehicle> findByPriceBetween(Double minPrice, Double maxPrice);
}
