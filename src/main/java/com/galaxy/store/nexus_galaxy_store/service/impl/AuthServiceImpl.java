package com.galaxy.store.nexus_galaxy_store.service.impl;

import com.galaxy.store.nexus_galaxy_store.dto.request.LoginRequest;
import com.galaxy.store.nexus_galaxy_store.dto.request.RegisterRequest;
import com.galaxy.store.nexus_galaxy_store.dto.response.AuthResponse;
import com.galaxy.store.nexus_galaxy_store.dto.response.UserResponse;
import com.galaxy.store.nexus_galaxy_store.entity.User;
import com.galaxy.store.nexus_galaxy_store.enums.UserRole;
import com.galaxy.store.nexus_galaxy_store.expeption.BadRequestException;
import com.galaxy.store.nexus_galaxy_store.expeption.ResourceNotFoundException;
import com.galaxy.store.nexus_galaxy_store.mapper.UserMapper;
import com.galaxy.store.nexus_galaxy_store.repository.UserRepository;
import com.galaxy.store.nexus_galaxy_store.security.jwt.JwtService;
import com.galaxy.store.nexus_galaxy_store.service.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    @Override
    public AuthResponse register(RegisterRequest request) {
        boolean exists = userRepository.findByEmail(request.getEmail()).isPresent();
        if (exists) {
            throw new BadRequestException("Email already exists.");
        }

        User user = User
                .builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(UserRole.CUSTOMER).build();
        User savedUser = userRepository.save(user);
        String token = jwtService.generateToken(savedUser.getEmail());
        return AuthResponse.builder().token(token).user(UserMapper.toResponse(savedUser)).build();
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        boolean matches = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!matches) {
            throw new BadRequestException("Invalid password");
        }

        String token = jwtService.generateToken(user.getEmail());
        return AuthResponse.builder().token(token).user(UserMapper.toResponse(user)).build();
    }
}

// passwordEncoder.encode() : Encrypts password before DB save
// passwordEncoder.matches() : Check raw password vs encrypted password