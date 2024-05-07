package com.example.ratingservice.controllers;

/**
 * Copyright (c) 2024 Wasif
 */

import com.example.ratingservice.dtos.commons.RatingDto;
import com.example.ratingservice.dtos.responses.ApiResponseDto;
import com.example.ratingservice.entities.Rating;
import com.example.ratingservice.services.RatingService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class is a controller class of {@link Rating}.
 * It processes the request and return the view as response.
 *
 * @author wasif
 * @version 1.0
 * @since 06/05/24
 */
@RestController
@RequestMapping("/ratings")
public class RatingController {
    private final RatingService ratingService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    /**
     * This method create new rating .
     *
     * @param RatingDto- dto to be created
     * @return json
     */
    @PostMapping
    public ResponseEntity<Object> add(@Valid @RequestBody RatingDto RatingDto) {
        logger.trace("Creating new rating entity with registration data => {}", RatingDto);
        return new ApiResponseDto().generateResponse(ratingService.add(RatingDto), "Successfully registered", HttpStatus.CREATED);
    }

    /**
     * This method is used to get all  {@link RatingDto}.
     *
     * @return json
     */
    @GetMapping
    public ResponseEntity<Object> getAll(@RequestParam(required = false, defaultValue = "true") Boolean isActive) {
        logger.trace("Getting all rating entity list");
        return new ApiResponseDto().generateResponse(ratingService.getAll(isActive), "Successfully data retrieved", HttpStatus.OK);
    }

    /**
     * This method is used to get a specific  {@link RatingDto}.
     *
     * @param id - rating id
     * @return json
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {

        logger.trace("Getting viewer entity by id => {}", id);
        return new ApiResponseDto().generateResponse(ratingService.getById(id), "Successfully data retrieved", HttpStatus.OK);
    }

    /**
     * This method is used to update a specific rating
     *
     * @param id        - id of the entity to find. Must not be null.
     * @param ratingDto - dto to be updated
     * @return json
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@Valid @PathVariable Long id, @RequestBody RatingDto ratingDto) {

        logger.trace("Updating rating by id => {} id with data => {}", id, ratingDto);
        return new ApiResponseDto().generateResponse(ratingService.update(id, ratingDto), "Successfully updated", HttpStatus.OK);

    }

    /**
     * This method is used to delete a specific rating
     *
     * @param id - id of the entity to delete. Must not be null.
     * @return json
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        logger.trace("Deleting rating entity by id => {}", id);
        ratingService.delete(id);
        return new ApiResponseDto().generateResponse(null, "Successfully deleted", HttpStatus.OK);
    }
}
