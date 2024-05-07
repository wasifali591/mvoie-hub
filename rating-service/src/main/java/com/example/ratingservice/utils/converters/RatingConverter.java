package com.example.ratingservice.utils.converters;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.ratingservice.dtos.commons.RatingDto;
import com.example.ratingservice.entities.Rating;

/**
 * This is a converter interface.
 * It used to map {@link Rating} entity class with {@link RatingDto} dto class.
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
public interface RatingConverter {

    /**
     * This method convert {@link Rating} to {@link RatingDto}
     *
     * @return {@link RatingDto}
     */
    RatingDto ratingToRatingDto(Rating rating);

    /**
     * This method convert {@link RatingDto} to {@link Rating}
     *
     * @return {@link Rating}
     */
    Rating ratingDtoToRating(RatingDto ratingDto);

    /**
     * This method update existing {@link Rating} by {@link RatingDto}
     *
     * @return {@link Rating}
     */
    Rating toUpdateRating(RatingDto ratingDto, Rating rating);
}
