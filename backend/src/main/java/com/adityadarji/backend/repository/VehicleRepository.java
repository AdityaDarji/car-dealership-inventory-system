package com.adityadarji.backend.repository;

import com.adityadarji.backend.entity.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
