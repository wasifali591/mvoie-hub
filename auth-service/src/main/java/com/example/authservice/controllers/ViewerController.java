package com.example.authservice.controllers;

/**
 * Copyright (c) 2024 Wasif
 */

import com.example.authservice.dtos.commons.ViewerDto;
import com.example.authservice.dtos.requests.ViewerRegistrationDto;
import com.example.authservice.dtos.responses.ApiResponseDto;
import com.example.authservice.entities.Viewer;
import com.example.authservice.services.ViewerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class is a controller class of {@link Viewer}.
 * It processes the request and return the view as response.
 *
 * @author wasif
 * @version 1.0
 * @since 06/05/24
 */
@RestController
@RequestMapping("/auth")
public class ViewerController {
    private final ViewerService viewerService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public ViewerController(ViewerService viewerService) {
        this.viewerService = viewerService;
    }

    /**
     * This method register new viewer using username and password.
     *
     * @param viewerRegistrationDto- dto to be registered
     * @return json
     */
    @PostMapping
    public ResponseEntity<Object> add(@Valid @RequestBody ViewerRegistrationDto viewerRegistrationDto) {
        logger.trace("Creating new viewer entity with registration data => {}", viewerRegistrationDto);
        return new ApiResponseDto().generateResponse(viewerService.add(viewerRegistrationDto), "Successfully registered", HttpStatus.CREATED);
    }

    /**
     * This method is used to get all  {@link ViewerDto}.
     *
     * @return json
     */
    @GetMapping
    public ResponseEntity<Object> getAll(@RequestParam(required = false, defaultValue = "true") Boolean isActive) {
        logger.trace("Getting all viewer entity list");
        return new ApiResponseDto().generateResponse(viewerService.getAll(isActive), "Successfully data retrieved", HttpStatus.OK);
    }

    /**
     * This method is used to get a specific  {@link ViewerDto}.
     *
     * @param id - viewer id
     * @return json
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {

        logger.trace("Getting viewer entity by id => {}", id);
        return new ApiResponseDto().generateResponse(viewerService.getById(id), "Successfully data retrieved", HttpStatus.OK);
    }

    /**
     * This method is used to update a specific viewer
     *
     * @param id        - id of the entity to find. Must not be null.
     * @param viewerDto - dto to be updated
     * @return json
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@Valid @PathVariable Long id, @RequestBody ViewerDto viewerDto) {

        logger.trace("Updating student viewer by id => {} id with data => {}", id, viewerDto);
        return new ApiResponseDto().generateResponse(viewerService.update(id, viewerDto), "Successfully updated", HttpStatus.OK);

    }

    /**
     * This method is used to delete a specific viewer
     *
     * @param id - id of the entity to delete. Must not be null.
     * @return json
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        logger.trace("Deleting viewer entity by id => {}", id);
        viewerService.delete(id);
        return new ApiResponseDto().generateResponse(null, "Successfully deleted", HttpStatus.OK);
    }
}
