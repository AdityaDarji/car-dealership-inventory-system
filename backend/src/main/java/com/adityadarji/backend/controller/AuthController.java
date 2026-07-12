package com.adityadarji.backend.controller;

import com.adityadarji.backend.dto.AuthResponse;
import com.adityadarji.backend.dto.LoginRequest;
import com.adityadarji.backend.dto.RegisterRequest;
import com.adityadarji.backend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(
            @Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @Valid @RequestBody LoginRequest request) {

        return authService.login(request);
    }
}
