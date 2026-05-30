package com.galaxy.store.nexus_galaxy_store.mapper;


import com.galaxy.store.nexus_galaxy_store.dto.response.UserResponse;
import com.galaxy.store.nexus_galaxy_store.entity.User;

public class UserMapper {

    public static UserResponse toResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
//
//🧠 WHY MAPPER EXISTS?
//
//Without mapper:
//
//Everywhere:
//
//        response.setName(user.getName())
//        response.setEmail(user.getEmail())
//
//Repeated chaos.
//
//Mapper centralizes transformation.