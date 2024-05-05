package com.example.authservice.exceptions;

/*
 * Copyright (c) 2024 Wasif.
 */

import org.springframework.http.HttpStatus;

/**
 * This is a custom exception class for already exist resource.
 * It extends {@link ApiException}
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
public class ResourceAlreadyExistsException extends ApiException {

    public ResourceAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}