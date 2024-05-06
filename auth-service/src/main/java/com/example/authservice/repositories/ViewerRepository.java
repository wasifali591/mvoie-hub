package com.example.authservice.repositories;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.authservice.entities.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * This is a repository interface which provides crud operation for {@link Viewer}
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
public interface ViewerRepository extends JpaRepository<Viewer, Long> {
    /**
     * Find {@link Viewer} entity by phone number.
     *
     * @param username - phone number to find entity. Must not be null.
     * @return Optional
     */
    Optional<Viewer> findByUsername(String username);
}
