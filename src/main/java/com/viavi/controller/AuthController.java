package com.viavi.controller;

import com.viavi.constant.EndpointConstant;
import com.viavi.constant.UrlConstant;
import com.viavi.payload.request.auth.LoginRequest;
import com.viavi.payload.request.auth.RegisterRequest;
import com.viavi.payload.response.auth.LoginResponse;
import com.viavi.payload.response.auth.RegisterResponse;
import com.viavi.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(value = {UrlConstant.URL_AUTH})
public class AuthController {

    AuthService authService;

    @PostMapping(value = {EndpointConstant.ENDPOINT_REGISTER})
    ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {

        return ResponseEntity.ok(authService.register(registerRequest));
    }

    @PostMapping(value = EndpointConstant.ENDPOINT_LOGIN)
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }

}
