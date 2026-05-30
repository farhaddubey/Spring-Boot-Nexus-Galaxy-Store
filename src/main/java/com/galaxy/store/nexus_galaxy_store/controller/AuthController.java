package com.galaxy.store.nexus_galaxy_store.controller;

import com.galaxy.store.nexus_galaxy_store.dto.request.LoginRequest;
import com.galaxy.store.nexus_galaxy_store.dto.request.RegisterRequest;
import com.galaxy.store.nexus_galaxy_store.dto.response.ApiResponse;
import com.galaxy.store.nexus_galaxy_store.dto.response.UserResponse;
import com.galaxy.store.nexus_galaxy_store.service.interfaces.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
//@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    public AuthController (AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> register(@Valid @RequestBody RegisterRequest request) {
        UserResponse response = authService.register(request);
        ApiResponse<UserResponse> apiResponse = ApiResponse.<UserResponse> builder()
                .success(true)
                .message("User registered successfully")
                .data(response)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserResponse>> login(@Valid @RequestBody LoginRequest request) {
        UserResponse response = authService.login(request);
        ApiResponse<UserResponse> apiResponse = ApiResponse.<UserResponse> builder()
                .success(true)
                .message("Login successful")
                .data(response)
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
//
//@RestController -> This class handles REST apis
//Spring automatically converts Java objects -> JSONS
//
//@RequestMapping("/api/auth")
//Base URL, All apis start with :
//
//@PostMapping("/register")
//POST /api/auth/register
//
//@RequestBody : Converts incoming JSON to java objects
//
//🧠 EXAMPLE FLOW
//
//Frontend sends:
//
//        {
//        "name":"Farhad",
//        "email":"farhad@gmail.com",
//        "password":"123456"
//        }
//
//Spring converts automatically into:
//
//RegisterRequest request
//
//😈 magic of Spring Boot.

//@Valid triggers Validations annotations.
// Without this : @NotBlank @Email @Size do nothing

// ResponseEntity : Professional response wrapper -> status code, headers, response body
//ResponseEntity.ok(); // 200
//HttpStatus.CREATED
// 400 BAD REQUEST -> VALIDATION ERRORS -> INVALID EMAIL , PASSWORD,
// 404 NOT  FOUND -> RESOURCE NOT PRESENT
