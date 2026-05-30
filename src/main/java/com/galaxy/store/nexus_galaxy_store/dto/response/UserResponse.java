package com.galaxy.store.nexus_galaxy_store.dto.response;

import com.galaxy.store.nexus_galaxy_store.enums.UserRole;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserResponse {

    private Long id;

    private String name;

    private String email;

    private UserRole role;
}

// SO IN THE RESPONSE WE ARE NOT EXPOSING THE PASSWORD
// NOT EVEN THE ENCRYPTED PASSWORD
// NEVER