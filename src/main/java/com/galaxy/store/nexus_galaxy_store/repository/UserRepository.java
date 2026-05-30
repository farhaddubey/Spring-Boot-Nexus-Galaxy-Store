package com.galaxy.store.nexus_galaxy_store.repository;

import com.galaxy.store.nexus_galaxy_store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}