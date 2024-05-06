package com.example.movieservice.utils.converters.impl;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.movieservice.dtos.commons.MovieDto;
import com.example.movieservice.dtos.requests.MovieRegistrationDto;
import com.example.movieservice.entities.Movie;
import com.example.movieservice.utils.converters.MovieConverter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * This class implement an interface {@link MovieConverter}
 * It contains conversion logic for {@link Movie}, {@link MovieDto}
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
@Component
public class MovieConverterImpl implements MovieConverter {

    private final ModelMapper modelMapper;

    public MovieConverterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public MovieRegistrationDto movieToMovieRegDto(Movie movie) {
        return modelMapper.map(movie, MovieRegistrationDto.class);
    }

    @Override
    public Movie movieRegDtoToMovie(MovieRegistrationDto movieRegistrationDto) {
        return modelMapper.map(movieRegistrationDto, Movie.class);
    }

    /**
     * This method convert {@link Movie} to {@link MovieDto}
     *
     * @param movie - movie details
     * @return {@link MovieDto}
     */
    @Override
    public MovieDto movieToMovieDto(Movie movie) {
        return modelMapper.map(movie, MovieDto.class);
    }

    /**
     * This method convert {@link MovieDto} to {@link Movie}
     *
     * @param movieDto - user dto details
     * @return {@link Movie}
     */
    @Override
    public Movie movieDtoToMovie(MovieDto movieDto) {
        return modelMapper.map(movieDto, Movie.class);
    }

    /**
     * This method convert {@link MovieDto} to {@link Movie}
     *
     * @param movieDto - user dto details
     * @param movie    - user details
     * @return {@link Movie}
     */
    @Override
    public Movie toUpdateMovie(MovieDto movieDto, Movie movie) {
        modelMapper.map(movieDto, movie);
        return movie;
    }
}
