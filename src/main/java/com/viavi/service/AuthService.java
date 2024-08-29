package com.viavi.service;

import com.viavi.payload.request.auth.LoginRequest;
import com.viavi.payload.request.auth.RegisterRequest;
import com.viavi.payload.response.auth.LoginResponse;
import com.viavi.payload.response.auth.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}
