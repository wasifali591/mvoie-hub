package com.example.ratingservice.utils.converters.impl;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.ratingservice.dtos.commons.RatingDto;
import com.example.ratingservice.entities.Rating;
import com.example.ratingservice.utils.converters.RatingConverter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * This class implement an interface {@link RatingConverter}
 * It contains conversion logic for {@link com.example.ratingservice.entities.Rating}, {@link RatingDto} and {@link RatingDto}
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
@Component
public class RatingConverterImpl implements RatingConverter {

    private final ModelMapper modelMapper;

    public RatingConverterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * This method convert {@link Rating} to {@link RatingDto}
     *
     * @param rating - user details
     * @return {@link RatingDto}
     */
    @Override
    public RatingDto ratingToRatingDto(Rating rating) {
        return modelMapper.map(rating, RatingDto.class);
    }

    /**
     * This method convert {@link RatingDto} to {@link Rating}
     *
     * @param ratingDto - user dto details
     * @return {@link Rating}
     */
    @Override
    public Rating ratingDtoToRating(RatingDto ratingDto) {
        return modelMapper.map(ratingDto, Rating.class);
    }

    /**
     * This method convert {@link RatingDto} to {@link Rating}
     *
     * @param ratingDto - user dto details
     * @param rating    - user details
     * @return {@link Rating}
     */
    @Override
    public Rating toUpdateRating(RatingDto ratingDto, Rating rating) {
        modelMapper.map(ratingDto, rating);
        return rating;
    }
}
