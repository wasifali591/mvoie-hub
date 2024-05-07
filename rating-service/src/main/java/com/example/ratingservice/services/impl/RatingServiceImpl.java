package com.example.ratingservice.services.impl;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.ratingservice.dtos.commons.RatingDto;
import com.example.ratingservice.entities.Rating;
import com.example.ratingservice.exceptions.OperationFailedException;
import com.example.ratingservice.exceptions.ResourceNotFoundException;
import com.example.ratingservice.repositories.RatingRepository;
import com.example.ratingservice.services.RatingService;
import com.example.ratingservice.utils.converters.RatingConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class implement an interface {@link RatingService}
 * It contain different business logic for Rating
 *
 * @author wasif
 * @version 1.0
 * @since 27/04/24
 */
@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final RatingConverter ratingConverter;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public RatingServiceImpl(RatingRepository ratingRepository, RatingConverter ratingConverter) {
        this.ratingRepository = ratingRepository;
        this.ratingConverter = ratingConverter;
    }

    /**
     * This method register new {@link Rating}.
     *
     * @param RatingDto - RatingDto to be registered
     * @return RatingDto - entity
     */
    @Override
    public RatingDto add(RatingDto RatingDto) {
        logger.debug("Into add entity service method with data =>{}", RatingDto);
//        if (ratingRepository.findBy(RatingDto.getUsername()).isPresent()) {
//            logger.error("Rating data already exist =>{}", RatingDto);
//            throw new ResourceAlreadyExistsException("Already Exists!");
//        }
        Rating Rating = ratingConverter.ratingDtoToRating(RatingDto);
        logger.debug("Converted Rating entity => {} from DTO", Rating);
        Rating = ratingRepository.save(Rating);
        logger.debug("Record saved =>{} in DB", Rating);
        //Check Rating is created or not
        if (null == Rating.getId()) {
            logger.error("Failed to save Rating in DB => {}", Rating);
            throw new OperationFailedException("Failed to create Rating");
        }

        RatingDto registrationDto = ratingConverter.ratingToRatingDto(Rating);
        logger.debug("Converted DTO => {} from Rating entity", registrationDto);
        return registrationDto;
    }

    /**
     * This method return the list of {@link RatingDto}.
     * It converts {@link Rating} entity to {@link RatingDto} by {@link RatingConverter}
     *
     * @return all RatingDto entity.
     */
    @Override
    public List<RatingDto> getAll(Boolean isActive) {
        logger.debug("Into getAll service method");
        List<Rating> ratingList;

        if (isActive) {
            ratingList = ratingRepository.findAllActive();
        } else {
            ratingList = ratingRepository.findAll();
        }

        if (ratingList.isEmpty()) {
            logger.error("No data available!");
            throw new ResourceNotFoundException("No data available!");
        }
        logger.debug("Fetched Rating list => {}", ratingList);
        return ratingList.stream().map(ratingConverter::ratingToRatingDto).collect(Collectors.toList());
    }

    /**
     * This method return the information of {@link RatingDto}.
     *
     * @param id - Rating id
     * @return RatingDto entity.
     */
    @Override
    public RatingDto getById(Long id) {
        logger.debug("Into get entity service method with id => {}", id);
        Optional<Rating> optionalRating;

        optionalRating = ratingRepository.findById(id);

        if (optionalRating.isEmpty()) {
            logger.error("No data available!");
            throw new ResourceNotFoundException("No data available!");
        }
        Rating Rating = optionalRating.get();
        logger.debug("Fetched Rating entity => {}", Rating);
        RatingDto RatingDto = ratingConverter.ratingToRatingDto(Rating);
        logger.debug("Converted DTO => {} from Rating entity", RatingDto);
        return RatingDto;
    }

    /**
     * This method update {@link Rating} identified by rating id.
     * It finds {@link Rating} by id and update its changes by converting {@link RatingDto} to {@link Rating},
     * using {@link RatingConverter} and save it.
     *
     * @param id        - id of the entity to find. Must not be null.
     * @param RatingDto - RatingDto to be updated
     * @return RatingDto entity
     */
    @Override
    public RatingDto update(Long id, RatingDto RatingDto) {
        logger.debug("Into update entity service method with id => {} and data => {}", id, RatingDto);
        if (!ratingRepository.existsById(id)) {
            logger.error("Resource doesn't exist!");
            throw new ResourceNotFoundException("Resource doesn't exist!");
        }

        Rating Rating = ratingConverter.ratingDtoToRating(RatingDto);
        logger.debug("Converted Rating entity => {} from DTO => {}", Rating, RatingDto);
        Rating.setId(id);
        Rating = ratingRepository.save(Rating);
        logger.debug("Rating record updated in DB=>{}", Rating);
        RatingDto dto = ratingConverter.ratingToRatingDto(Rating);
        logger.debug("Converted DTO => {} from Rating entity", dto);
        return dto;
    }

    /**
     * This method delete the {@link Rating} entity identified by the given id
     *
     * @param id - the id of the entity to be deleted. Must not be null.
     * @return true of false
     */
    @Override
    public Boolean delete(Long id) {
        logger.debug("Into delete entity service method with id => {}", id);
        // Validate.
        if (ratingRepository.findById(id).isEmpty()) {
            logger.error("Resource doesn't exist!");
            throw new ResourceNotFoundException("Resource doesn't exist!");
        }

        Rating rating = ratingRepository.getById(id);
        logger.debug("Fetching Rating entity by id => {} from DB using repository", id);

        //delete rating
        rating.setIsActive(false);
        ratingRepository.save(rating);
        logger.debug("Rating entity deleted from DB=>{}", rating);
        return true;

    }
}
