package com.galaxy.store.nexus_galaxy_store.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse<T> {

    private boolean success;

    private String message;

    private T data;
}

// GENERIC API RESPONSE
// VERY IMPORTANT
// PROFESSIONAL APIS RETURN STANDARD FORMAT
//
//🧠 WHY THIS MATTERS?
//
//Instead of random responses:
//
//BAD:
//
//        {
//        "name":"Farhad"
//        }
//
//Another API:
//
//        {
//        "user":"Farhad"
//        }
//
//Another:
//
//        {
//        "result":"Farhad"
//        }
//
//        😑 inconsistency chaos.
//
//        🔥 STANDARDIZED RESPONSE
//{
//        "success": true,
//        "message": "User fetched successfully",
//        "data": {
//        "id": 1,
//        "name": "Farhad"
//        }
//        }
//
//Beautiful.
//
//        Scalable.
//
//Frontend friendly.