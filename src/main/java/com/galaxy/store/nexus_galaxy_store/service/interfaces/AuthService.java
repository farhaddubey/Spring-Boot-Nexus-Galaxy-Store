package com.galaxy.store.nexus_galaxy_store.service.interfaces;

import com.galaxy.store.nexus_galaxy_store.dto.request.LoginRequest;
import com.galaxy.store.nexus_galaxy_store.dto.request.RegisterRequest;
import com.galaxy.store.nexus_galaxy_store.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}

// Why interfaces first ??
// Because controllers depends on contracts not implementations.