package com.example.ratingservice.exceptions;

/*
 * Copyright (c) 2024 Wasif.
 */

import org.springframework.http.HttpStatus;

/**
 * This is a custom exception class for resource not found.
 * It extends {@link ApiException}
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2014
 */
public class ResourceNotFoundException extends ApiException {

    public ResourceNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
