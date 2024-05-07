package com.example.ratingservice.repositories;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.ratingservice.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * This is a repository interface which provides crud operation for {@link Rating}
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
public interface RatingRepository extends JpaRepository<Rating, Long> {


    /**
     * Find all active {@link Rating}
     *
     * @return list of rating
     */
    @Query("SELECT R FROM Rating R WHERE R.isActive=true")
    List<Rating> findAllActive();
}
