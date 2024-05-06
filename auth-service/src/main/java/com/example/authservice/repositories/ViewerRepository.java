package com.example.authservice.repositories;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.authservice.entities.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is a repository interface which provides crud operation for {@link Viewer}
 */
public interface ViewerRepository extends JpaRepository<Viewer, Long> {
}
