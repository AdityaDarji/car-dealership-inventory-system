package com.adityadarji.backend.controller;

import com.adityadarji.backend.dto.RestockRequest;
import com.adityadarji.backend.dto.VehicleDTO;
import com.adityadarji.backend.entity.Vehicle;
import com.adityadarji.backend.service.VehicleService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public Vehicle createCar(@Valid @RequestBody Vehicle car) {
        return vehicleService.createVehicle(car);
    }

    @GetMapping
    public List<VehicleDTO> getAllCars() {
        return vehicleService.getAllVehicle();
    }

    @GetMapping("/{id}")
    public Vehicle getCarById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    @PutMapping("/{id}")
    public Vehicle updateCar(@PathVariable Long id,
            @Valid @RequestBody Vehicle car) {

        return vehicleService.updateVehicle(id, car);
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable Long id) {

        vehicleService.deleteVehicle(id);

        return "Car deleted successfully.";
    }

    @PostMapping("/{id}/purchase")
    public VehicleDTO purchaseVehicle(
            @PathVariable Long id) {

        return vehicleService.purchaseVehicle(id);
    }

    @PostMapping("/{id}/restock")
    public VehicleDTO restockVehicle(

            @PathVariable Long id,

            @Valid @RequestBody RestockRequest request) {

        return vehicleService.restockVehicle(
                id,
                request.getQuantity());
    }

    @GetMapping("/search")
    public List<VehicleDTO> searchVehicles(

            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {

        return vehicleService.searchVehicles(
                brand,
                model,
                category,
                minPrice,
                maxPrice);
    }
}