package com.adityadarji.backend.controller;

import com.adityadarji.backend.dto.AuthResponse;
import com.adityadarji.backend.service.AuthService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AuthService authService;

    @Test
    void registerTest() throws Exception {

        when(authService.register(any()))
                .thenReturn("User Registered");

        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                          "name":"Aditya",
                          "email":"test@test.com",
                          "password":"12345",
                          "role":"ADMIN"
                        }
                        """))
                .andExpect(status().isOk());

    }

    @Test
    void loginTest() throws Exception {

        AuthResponse response = new AuthResponse(null);

        response.setToken("dummy-token");

        when(authService.login(any()))
                .thenReturn(response);

        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                          "email":"test@test.com",
                          "password":"12345"
                        }
                        """))
                .andExpect(status().isOk());

    }

}
