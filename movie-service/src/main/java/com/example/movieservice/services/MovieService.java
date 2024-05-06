package com.example.movieservice.services;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.movieservice.dtos.commons.MovieDto;
import com.example.movieservice.dtos.requests.MovieRegistrationDto;
import com.example.movieservice.entities.Movie;

import java.util.List;

/**
 * This interface provides create, retrieve, update and delete operation for {@link Movie}.
 *
 * @author wasif
 * @version 1.0
 * @since 06/05/24
 */
public interface MovieService {

    /**
     * This method add {@link Movie}.
     *
     * @param movieRegistrationDto - Movie to be registered
     * @return {@link MovieRegistrationDto}
     */
    MovieRegistrationDto add(MovieRegistrationDto movieRegistrationDto);

    /**
     * This method return the list of {@link Movie}
     *
     * @return list of {@link MovieDto}
     */
    List<MovieDto> getAll(Boolean isActive);

    /**
     * This method return a specific {@link MovieDto} entity identified by the {@link Movie} id.
     *
     * @param id - - id of the entity to find. Must not be null.
     * @return {@link MovieDto}
     */
    MovieDto getById(Long id);

    /**
     * This method update {@link Movie} identified by movie id.
     *
     * @param id       - id of the entity to update. Must not be null.
     * @param movieDto - {@link MovieDto} to be updated
     * @return {@link MovieDto}
     */
    MovieDto update(Long id, MovieDto movieDto);

    /**
     * This method delete the {@link Movie} entity identified by the given id.
     *
     * @param id - id of the {@link Movie} entity to delete. Must not be null.
     * @return true or false
     */
    Boolean delete(Long id);
}
