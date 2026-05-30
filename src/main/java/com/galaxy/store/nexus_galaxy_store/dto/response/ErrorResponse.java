package com.galaxy.store.nexus_galaxy_store.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
public class ErrorResponse {

    private boolean success;

    private String message;

    private int status;

    private LocalDateTime timestamp;

    private Map<String, String> errors;
}

// Because frontend requires strictly consistent data
// Every error response follows same format
