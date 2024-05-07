package com.example.ratingservice.services;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.ratingservice.dtos.commons.RatingDto;
import com.example.ratingservice.entities.Rating;

import java.util.List;

/**
 * This interface provides create, retrieve, update and delete operation for {@link Rating}.
 *
 * @author wasif
 * @version 1.0
 * @since 06/05/24
 */
public interface RatingService {

    /**
     * This method add nre {@link Rating}.
     *
     * @param RatingDto - Rating to be registered
     * @return {@link RatingDto}
     */
    RatingDto add(RatingDto RatingDto);

    /**
     * This method return the list of {@link Rating}
     *
     * @return list of {@link RatingDto}
     */
    List<RatingDto> getAll(Boolean isActive);

    /**
     * This method return a specific {@link RatingDto} entity identified by the {@link Rating} id.
     *
     * @param id - - id of the entity to find. Must not be null.
     * @return {@link RatingDto}
     */
    RatingDto getById(Long id);

    /**
     * This method update {@link Rating} identified by student id.
     *
     * @param id        - id of the entity to update. Must not be null.
     * @param ratingDto - {@link RatingDto} to be updated
     * @return {@link RatingDto}
     */
    RatingDto update(Long id, RatingDto ratingDto);

    /**
     * This method delete the {@link Rating} entity identified by the given id.
     *
     * @param id - id of the {@link Rating} entity to delete. Must not be null.
     * @return true or false
     */
    Boolean delete(Long id);
}
