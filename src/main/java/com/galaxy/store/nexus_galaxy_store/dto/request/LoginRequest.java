package com.galaxy.store.nexus_galaxy_store.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @Email(message = "Invalid Email")
    @NotBlank(message = "Email required.")
    private String email;

    @NotBlank(message = "Password required.")
    private String password;
}
