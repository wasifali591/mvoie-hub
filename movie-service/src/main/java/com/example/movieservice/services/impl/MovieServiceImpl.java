package com.example.movieservice.services.impl;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.movieservice.dtos.commons.MovieDto;
import com.example.movieservice.dtos.requests.MovieRegistrationDto;
import com.example.movieservice.entities.Movie;
import com.example.movieservice.exceptions.OperationFailedException;
import com.example.movieservice.exceptions.ResourceAlreadyExistsException;
import com.example.movieservice.exceptions.ResourceNotFoundException;
import com.example.movieservice.repositories.MovieRepository;
import com.example.movieservice.services.MovieService;
import com.example.movieservice.utils.converters.MovieConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class implement an interface {@link MovieService}
 * It contain different business logic for Movie
 *
 * @author wasif
 * @version 1.0
 * @since 27/04/24
 */
@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final MovieConverter movieConverter;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public MovieServiceImpl(MovieRepository movieRepository, MovieConverter movieConverter) {
        this.movieRepository = movieRepository;
        this.movieConverter = movieConverter;
    }

    /**
     * This method register new {@link Movie}.
     * It gets movie name from {@link MovieRegistrationDto} ,
     * if movie name is not present then {@link MovieDto} convert to {@link Movie} by {@link MovieConverter},
     * and save {@link Movie}.
     *
     * @param movieRegistrationDto - movie to be registered
     * @return movieDto - entity
     */
    @Override
    public MovieRegistrationDto add(MovieRegistrationDto movieRegistrationDto) {
        logger.debug("Into add entity service method with data =>{}", movieRegistrationDto);
        if (movieRepository.findByName(movieRegistrationDto.getName()).isPresent()) {
            logger.error("Movie data already exist =>{}", movieRegistrationDto);
            throw new ResourceAlreadyExistsException("Already Exists!");
        }
        Movie movie = movieConverter.movieRegDtoToMovie(movieRegistrationDto);
        logger.debug("Converted Movie entity => {} from DTO", movie);
        movie = movieRepository.save(movie);
        logger.debug("Record saved =>{} in DB", movie);
        //Check Movie is created or not
        if (null == movie.getId()) {
            logger.error("Failed to save Movie in DB => {}", movie);
            throw new OperationFailedException("Failed to create Movie");
        }

        MovieRegistrationDto registrationDto = movieConverter.movieToMovieRegDto(movie);
        logger.debug("Converted DTO => {} from Movie entity", registrationDto);
        return registrationDto;
    }

    /**
     * This method return the list of {@link MovieDto}.
     * It converts {@link Movie} entity to {@link MovieDto} by {@link MovieConverter}
     *
     * @return all MovieDto entity.
     */
    @Override
    public List<MovieDto> getAll(Boolean isActive) {
        logger.debug("Into getAll service method");
        List<Movie> movieList;

        if (isActive) {
            movieList = movieRepository.findAllActive();
        } else {
            movieList = movieRepository.findAll();
        }

        if (movieList.isEmpty()) {
            logger.error("No data available!");
            throw new ResourceNotFoundException("No data available!");
        }
        logger.debug("Fetched Movie list => {}", movieList);
        return movieList.stream().map(movieConverter::movieToMovieDto).collect(Collectors.toList());
    }

    /**
     * This method return the information of {@link MovieDto}.
     *
     * @param id - Movie id
     * @return MovieDto entity.
     */
    @Override
    public MovieDto getById(Long id) {
        logger.debug("Into get entity service method with id => {}", id);
        Optional<Movie> optionalViewer;

        optionalViewer = movieRepository.findById(id);

        if (optionalViewer.isEmpty()) {
            logger.error("No data available!");
            throw new ResourceNotFoundException("No data available!");
        }
        Movie Movie = optionalViewer.get();
        logger.debug("Fetched Movie entity => {}", Movie);
        MovieDto MovieDto = movieConverter.movieToMovieDto(Movie);
        logger.debug("Converted DTO => {} from Movie entity", MovieDto);
        return MovieDto;
    }

    /**
     * This method update {@link Movie} identified by movie id.
     * It finds {@link Movie} by id and update its changes by converting {@link MovieDto} to {@link Movie},
     * using {@link MovieConverter} and save it.
     *
     * @param id       - id of the entity to find. Must not be null.
     * @param MovieDto - MovieDto to be updated
     * @return MovieDto entity
     */
    @Override
    public MovieDto update(Long id, MovieDto MovieDto) {
        logger.debug("Into update entity service method with id => {} and data => {}", id, MovieDto);
        if (!movieRepository.existsById(id)) {
            logger.error("Resource doesn't exist!");
            throw new ResourceNotFoundException("Resource doesn't exist!");
        }

        Movie Movie = movieConverter.movieDtoToMovie(MovieDto);
        logger.debug("Converted Movie entity => {} from DTO => {}", Movie, MovieDto);
        Movie.setId(id);
        Movie = movieRepository.save(Movie);
        logger.debug("Movie record updated in DB=>{}", Movie);
        MovieDto dto = movieConverter.movieToMovieDto(Movie);
        logger.debug("Converted DTO => {} from Movie entity", dto);
        return dto;
    }

    /**
     * This method delete the {@link Movie} entity identified by the given id
     *
     * @param id - the id of the entity to be deleted. Must not be null.
     * @return true of false
     */
    @Override
    public Boolean delete(Long id) {
        logger.debug("Into delete entity service method with id => {}", id);
        // Validate.
        if (movieRepository.findById(id).isEmpty()) {
            logger.error("Resource doesn't exist!");
            throw new ResourceNotFoundException("Resource doesn't exist!");
        }

        Movie movie = movieRepository.getById(id);
        logger.debug("Fetching Movie entity by id => {} from DB using repository", id);

        //delete movie
        movie.setIsActive(false);
        movieRepository.save(movie);
        logger.debug("Movie entity deleted from DB=>{}", movie);
        return true;

    }
}
