package com.example.movieservice.utils.converters;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.movieservice.dtos.commons.MovieDto;
import com.example.movieservice.dtos.requests.MovieRegistrationDto;
import com.example.movieservice.entities.Movie;

/**
 * This is a converter interface.
 * It used to map {@link Movie} entity class with {@link MovieDto} dto class.
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
public interface MovieConverter {

    /**
     * This method convert {@link Movie} to {@link MovieRegistrationDto}
     *
     * @return {@link MovieRegistrationDto}
     */
    MovieRegistrationDto movieToMovieRegDto(Movie movie);

    /**
     * This method convert {@link MovieRegistrationDto} to {@link Movie}
     *
     * @return {@link Movie}
     */
    Movie movieRegDtoToMovie(MovieRegistrationDto movieRegistrationDto);

    /**
     * This method convert {@link Movie} to {@link MovieDto}
     *
     * @return {@link MovieDto}
     */
    MovieDto movieToMovieDto(Movie movie);

    /**
     * This method convert {@link MovieDto} to {@link Movie}
     *
     * @return {@link Movie}
     */
    Movie movieDtoToMovie(MovieDto movieDto);

    /**
     * This method update existing {@link Movie} by {@link MovieDto}
     *
     * @return {@link Movie}
     */
    com.example.movieservice.entities.Movie toUpdateMovie(MovieDto movieDto, Movie movie);
}
