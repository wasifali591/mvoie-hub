package com.example.authservice.repositories;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.authservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is a repository interface which provides crud operation for {@link User}
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
