package com.example.authservice.utils.converters;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.authservice.dtos.commons.ViewerDto;
import com.example.authservice.dtos.requests.ViewerRegistrationDto;
import com.example.authservice.entities.Viewer;

/**
 * This is a converter interface.
 * It used to map {@link Viewer} entity class with {@link ViewerDto} and {@link ViewerRegistrationDto} dto class.
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
public interface ViewerConverter {
    /**
     * This method convert {@link Viewer} to {@link ViewerRegistrationDto}
     *
     * @return {@link ViewerRegistrationDto}
     */
    ViewerRegistrationDto viewerToViewerRegDto(Viewer viewer);

    /**
     * This method convert {@link ViewerRegistrationDto} to {@link Viewer}
     *
     * @return {@link Viewer}
     */
    Viewer viewerRegDtoToViewer(ViewerRegistrationDto viewerRegistrationDto);

    /**
     * This method convert {@link Viewer} to {@link ViewerDto}
     *
     * @return {@link ViewerDto}
     */
    ViewerDto viewerToViewerDto(Viewer viewer);

    /**
     * This method convert {@link ViewerDto} to {@link Viewer}
     *
     * @return {@link Viewer}
     */
    Viewer viewerDtoToViewer(ViewerDto viewerDto);

    /**
     * This method update existing {@link Viewer} by {@link ViewerDto}
     *
     * @return {@link Viewer}
     */
    Viewer toUpdateViewer(ViewerDto viewerDto, Viewer viewer);
}
