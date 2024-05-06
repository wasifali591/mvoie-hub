package com.example.movieservice.repositories;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.movieservice.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * This is a repository interface which provides crud operation for {@link Movie}
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {
    /**
     * Find {@link Movie} entity by movie name.
     *
     * @param name - movie name to find entity. Must not be null.
     * @return Optional
     */
    Optional<Movie> findByName(String name);

    /**
     * Find all active {@link Movie}
     *
     * @return list of movie
     */
    @Query("SELECT M FROM Movie M WHERE M.isActive=true")
    List<Movie> findAllActive();

}
