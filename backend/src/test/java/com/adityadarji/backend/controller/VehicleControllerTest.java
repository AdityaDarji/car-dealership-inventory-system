package com.adityadarji.backend.controller;

import com.adityadarji.backend.entity.Vehicle;
import com.adityadarji.backend.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VehicleController.class)
@AutoConfigureMockMvc(addFilters = false)
class VehicleControllerTest {

        @Autowired
        MockMvc mockMvc;

        @MockBean
        VehicleService vehicleService;

        @Test
        void createVehicleTest() throws Exception {

                Vehicle vehicle = new Vehicle();

                vehicle.setId(1L);
                vehicle.setBrand("Toyota");

                when(vehicleService.createVehicle(any(Vehicle.class)))
                                .thenReturn(vehicle);

                mockMvc.perform(post("/api/vehicle")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                                {
                                                  "brand":"Toyota"
                                                }
                                                """))
                                .andExpect(status().isOk());
        }

        @Test
        void getAllVehiclesTest() throws Exception {

                mockMvc.perform(get("/api/vehicle"))
                                .andExpect(status().isOk());
        }

        @Test
        void deleteVehicleTest() throws Exception {

                doNothing().when(vehicleService).deleteVehicle(1L);

                mockMvc.perform(delete("/api/vehicle/1"))
                                .andExpect(status().isOk());
        }
}
