package com.example.authservice.services;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.authservice.entities.Viewer;
import com.example.authservice.dtos.requests.ViewerRegistrationDto;
import com.example.authservice.dtos.commons.ViewerDto;

import java.util.List;

/**
 * This interface provides create, retrieve, update and delete operation for {@link Viewer}.
 *
 * @author wasif
 * @version 1.0
 * @since 06/05/24
 */
public interface ViewerService {

    /**
     * This method add nre {@link Viewer}.
     *
     * @param viewerRegistrationDto - Viewer to be registered
     * @return {@link ViewerRegistrationDto}
     */
    ViewerRegistrationDto add(ViewerRegistrationDto viewerRegistrationDto);

    /**
     * This method return the list of {@link Viewer}
     *
     * @return list of {@link ViewerDto}
     */
    List<ViewerDto> getAll(Boolean isActive);

    /**
     * This method return a specific {@link ViewerDto} entity identified by the {@link Viewer} id.
     *
     * @param id - - id of the entity to find. Must not be null.
     * @return {@link ViewerDto}
     */
    ViewerDto getById(Long id);

    /**
     * This method update {@link Viewer} identified by student id.
     *
     * @param id         - id of the entity to update. Must not be null.
     * @param viewerDto - {@link ViewerDto} to be updated
     * @return {@link ViewerDto}
     */
    ViewerDto update(Long id, ViewerDto viewerDto);

    /**
     * This method delete the {@link Viewer} entity identified by the given id.
     *
     * @param id - id of the {@link Viewer} entity to delete. Must not be null.
     * @return true or false
     */
    Boolean delete(Long id);
}
