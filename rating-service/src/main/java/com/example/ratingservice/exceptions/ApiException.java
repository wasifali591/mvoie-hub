package com.example.ratingservice.exceptions;

/*
 * Copyright (c) 2024 Wasif.
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * This is a custom exception class.
 * It extends {@link RuntimeException}.
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
@Getter
@AllArgsConstructor
public class ApiException extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;
}

