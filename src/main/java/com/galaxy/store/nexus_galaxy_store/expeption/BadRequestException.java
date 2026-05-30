package com.galaxy.store.nexus_galaxy_store.expeption;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}