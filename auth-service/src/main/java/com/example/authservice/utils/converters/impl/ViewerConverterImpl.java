package com.example.authservice.utils.converters.impl;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.authservice.dtos.commons.ViewerDto;
import com.example.authservice.dtos.requests.ViewerRegistrationDto;
import com.example.authservice.entities.Viewer;
import com.example.authservice.utils.converters.ViewerConverter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * This class implement an interface {@link ViewerConverter}
 * It contains conversion logic for {@link Viewer}, {@link ViewerDto} and {@link ViewerRegistrationDto}
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
@Component
public class ViewerConverterImpl implements ViewerConverter {

    private final ModelMapper modelMapper;

    public ViewerConverterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * This method convert {@link Viewer} to {@link ViewerRegistrationDto}
     *
     * @param viewer - user details
     * @return {@link ViewerRegistrationDto}
     */
    @Override
    public ViewerRegistrationDto viewerToViewerRegDto(Viewer viewer) {
        return modelMapper.map(viewer, ViewerRegistrationDto.class);
    }

    /**
     * This method convert {@link ViewerRegistrationDto} to {@link Viewer}
     *
     * @param viewerRegistrationDto - user registration details
     * @return {@link Viewer}
     */
    @Override
    public Viewer viewerRegDtoToViewer(ViewerRegistrationDto viewerRegistrationDto) {
        return modelMapper.map(viewerRegistrationDto, Viewer.class);
    }

    /**
     * This method convert {@link Viewer} to {@link ViewerDto}
     *
     * @param viewer - user details
     * @return {@link ViewerDto}
     */
    @Override
    public ViewerDto viewerToViewerDto(Viewer viewer) {
        return modelMapper.map(viewer, ViewerDto.class);
    }

    /**
     * This method convert {@link ViewerDto} to {@link Viewer}
     *
     * @param viewerDto - user dto details
     * @return {@link Viewer}
     */
    @Override
    public Viewer viewerDtoToViewer(ViewerDto viewerDto) {
        return modelMapper.map(viewerDto, Viewer.class);
    }

    /**
     * This method convert {@link ViewerDto} to {@link Viewer}
     *
     * @param viewerDto - user dto details
     * @param viewer    - user details
     * @return {@link Viewer}
     */
    @Override
    public Viewer toUpdateViewer(ViewerDto viewerDto, Viewer viewer) {
        return null;
    }
}
