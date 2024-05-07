package com.example.ratingservice.exceptions;

/*
 * Copyright (c) 2024 Wasif.
 */

import org.springframework.http.HttpStatus;

/**
 * This is a custom exception class for operation failed.
 * It extends {@link ApiException}
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
public class OperationFailedException extends ApiException {

    public OperationFailedException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
