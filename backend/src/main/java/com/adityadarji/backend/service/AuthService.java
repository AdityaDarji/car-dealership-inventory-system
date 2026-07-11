package com.adityadarji.backend.service;

import com.adityadarji.backend.dto.LoginRequest;
import com.adityadarji.backend.dto.RegisterRequest;

public interface AuthService {
    String register(RegisterRequest request);

    String login(LoginRequest request);

}
