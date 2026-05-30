package com.galaxy.store.nexus_galaxy_store.expeption;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}