package com.example.movieservice.configuration;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.movieservice.dtos.responses.ApiResponseDto;
import com.example.movieservice.exceptions.ApiException;
import com.example.movieservice.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This is a configuration class for Exception Handler.
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * This method handle any exceptions to the type {@link ApiException}
     *
     * @param exception - custom Exception to be thrown
     * @return response
     */
    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<Object> handleApiException(ApiException exception) {
        return new ApiResponseDto().generateResponse(null, exception.getMessage(), exception.getHttpStatus());
    }

    /**
     * This method handle any exceptions to the type {@link ValidationException}
     *
     * @param exception - custom Exception to be thrown
     * @return response
     */
    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<Object> handleValidationException(ValidationException exception) {
        return new ApiResponseDto().generateResponse(null, exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

