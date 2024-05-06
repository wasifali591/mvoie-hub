package com.example.movieservice.controllers;

/**
 * Copyright (c) 2024 Wasif
 */

import com.example.movieservice.dtos.commons.MovieDto;
import com.example.movieservice.dtos.requests.MovieRegistrationDto;
import com.example.movieservice.dtos.responses.ApiResponseDto;
import com.example.movieservice.entities.Movie;
import com.example.movieservice.services.MovieService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class is a controller class of {@link Movie}.
 * It processes the request and return the view as response.
 *
 * @author wasif
 * @version 1.0
 * @since 06/05/24
 */
@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * This method register new movie using {@link MovieRegistrationDto}.
     *
     * @param movieRegistrationDto- dto to be registered
     * @return json
     */
    @PostMapping
    public ResponseEntity<Object> add(@Valid @RequestBody MovieRegistrationDto movieRegistrationDto) {
        logger.trace("Creating new movie entity with registration data => {}", movieRegistrationDto);
        return new ApiResponseDto().generateResponse(movieService.add(movieRegistrationDto), "Successfully registered", HttpStatus.CREATED);
    }

    /**
     * This method is used to get all  {@link MovieDto}.
     *
     * @return json
     */
    @GetMapping
    public ResponseEntity<Object> getAll(@RequestParam(required = false, defaultValue = "true") Boolean isActive) {
        logger.trace("Getting all movie entity list");
        return new ApiResponseDto().generateResponse(movieService.getAll(isActive), "Successfully data retrieved", HttpStatus.OK);
    }

    /**
     * This method is used to get a specific  {@link MovieDto}.
     *
     * @param id - movie id
     * @return json
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {

        logger.trace("Getting movie entity by id => {}", id);
        return new ApiResponseDto().generateResponse(movieService.getById(id), "Successfully data retrieved", HttpStatus.OK);
    }

    /**
     * This method is used to update a specific movie
     *
     * @param id       - id of the entity to find. Must not be null.
     * @param movieDto - dto to be updated
     * @return json
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@Valid @PathVariable Long id, @RequestBody MovieDto movieDto) {

        logger.trace("Updating movie by id => {} id with data => {}", id, movieDto);
        return new ApiResponseDto().generateResponse(movieService.update(id, movieDto), "Successfully updated", HttpStatus.OK);

    }

    /**
     * This method is used to delete a specific movie
     *
     * @param id - id of the entity to delete. Must not be null.
     * @return json
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        logger.trace("Deleting movie entity by id => {}", id);
        movieService.delete(id);
        return new ApiResponseDto().generateResponse(null, "Successfully deleted", HttpStatus.OK);
    }
}
