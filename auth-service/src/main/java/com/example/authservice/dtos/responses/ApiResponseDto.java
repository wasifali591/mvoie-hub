package com.example.authservice.dtos.responses;

/*
 * Copyright (c) 2024 Wasif.
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a dto class for custom response handler.
 * It is used to generate response.
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
public class ApiResponseDto {
    public ResponseEntity<Object> generateResponse(Object body, String message, HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status.value());
        map.put("payload", body);
        map.put("message", message);
        return new ResponseEntity<>(map, status);
    }
}