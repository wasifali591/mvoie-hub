package com.example.authservice.exceptions;

/*
 * Copyright (c) 2024 Wasif.
 */

import org.springframework.http.HttpStatus;

/**
 * This is a custom exception class for validation.
 * It extends {@link ApiException}.
 * It validates user inputs
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
public class ValidationException extends ApiException {

    public ValidationException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}