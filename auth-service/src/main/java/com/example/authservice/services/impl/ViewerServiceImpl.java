package com.example.authservice.services.impl;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.authservice.dtos.commons.ViewerDto;
import com.example.authservice.dtos.requests.ViewerRegistrationDto;
import com.example.authservice.entities.Viewer;
import com.example.authservice.exceptions.OperationFailedException;
import com.example.authservice.exceptions.ResourceAlreadyExistsException;
import com.example.authservice.exceptions.ResourceNotFoundException;
import com.example.authservice.repositories.ViewerRepository;
import com.example.authservice.services.ViewerService;
import com.example.authservice.utils.converters.ViewerConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class implement an interface {@link ViewerService}
 * It contain different business logic for Viewer
 *
 * @author wasif
 * @version 1.0
 * @since 27/04/24
 */
@Service
public class ViewerServiceImpl implements ViewerService {
    private final ViewerRepository viewerRepository;
    private final ViewerConverter viewerConverter;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public ViewerServiceImpl(ViewerRepository viewerRepository, ViewerConverter viewerConverter) {
        this.viewerRepository = viewerRepository;
        this.viewerConverter = viewerConverter;
    }

    /**
     * This method register new {@link Viewer}.
     * It gets phone number from {@link ViewerDto} body,
     * if phone number is not registered then {@link ViewerDto} convert to {@link Viewer} by {@link ViewerConverter},
     * and save {@link Viewer}.
     *
     * @param viewerRegistrationDto - ViewerDto to be registered
     * @return ViewerRegistrationDto - entity
     */
    @Override
    public ViewerRegistrationDto add(ViewerRegistrationDto viewerRegistrationDto) {
        logger.debug("Into add entity service method with data =>{}", viewerRegistrationDto);
        if (viewerRepository.findByUsername(viewerRegistrationDto.getUsername()).isPresent()) {
            logger.error("Viewer data already exist =>{}", viewerRegistrationDto);
            throw new ResourceAlreadyExistsException("Already Exists!");
        }
        Viewer Viewer = viewerConverter.viewerRegDtoToViewer(viewerRegistrationDto);
        logger.debug("Converted Viewer entity => {} from DTO", Viewer);
        Viewer = viewerRepository.save(Viewer);
        logger.debug("Record saved =>{} in DB", Viewer);
        //Check Viewer is created or not
        if (null == Viewer.getId()) {
            logger.error("Failed to save Viewer in DB => {}", Viewer);
            throw new OperationFailedException("Failed to create Viewer");
        }

        ViewerRegistrationDto registrationDto = viewerConverter.viewerToViewerRegDto(Viewer);
        logger.debug("Converted DTO => {} from Viewer entity", registrationDto);
        return registrationDto;
    }

    /**
     * This method return the list of {@link ViewerDto}.
     * It converts {@link Viewer} entity to {@link ViewerDto} by {@link ViewerConverter}
     *
     * @return all ViewerDto entity.
     */
    @Override
    public List<ViewerDto> getAll(Boolean isActive) {
        logger.debug("Into getAll service method");
        List<Viewer> viewerList;

        if (isActive) {
            viewerList = viewerRepository.findAllAllActive();
        } else {
            viewerList = viewerRepository.findAll();
        }

        if (viewerList.isEmpty()) {
            logger.error("No data available!");
            throw new ResourceNotFoundException("No data available!");
        }
        logger.debug("Fetched Viewer list => {}", viewerList);
        return viewerList.stream().map(viewerConverter::viewerToViewerDto).collect(Collectors.toList());
    }

    /**
     * This method return the information of {@link ViewerDto}.
     *
     * @param id - Viewer id
     * @return ViewerDto entity.
     */
    @Override
    public ViewerDto getById(Long id) {
        logger.debug("Into get entity service method with id => {}", id);
        Optional<Viewer> optionalViewer;

        optionalViewer = viewerRepository.findById(id);

        if (optionalViewer.isEmpty()) {
            logger.error("No data available!");
            throw new ResourceNotFoundException("No data available!");
        }
        Viewer Viewer = optionalViewer.get();
        logger.debug("Fetched Viewer entity => {}", Viewer);
        ViewerDto ViewerDto = viewerConverter.viewerToViewerDto(Viewer);
        logger.debug("Converted DTO => {} from Viewer entity", ViewerDto);
        return ViewerDto;
    }

    /**
     * This method update {@link Viewer} identified by ViewerID.
     * It finds {@link Viewer} by id and update its changes by converting {@link ViewerDto} to {@link Viewer},
     * using {@link ViewerConverter} and save it.
     *
     * @param id        - id of the entity to find. Must not be null.
     * @param ViewerDto - ViewerDto to be updated
     * @return ViewerDto entity
     */
    @Override
    public ViewerDto update(Long id, ViewerDto ViewerDto) {
        logger.debug("Into update entity service method with id => {} and data => {}", id, ViewerDto);
        if (!viewerRepository.existsById(id)) {
            logger.error("Resource doesn't exist!");
            throw new ResourceNotFoundException("Resource doesn't exist!");
        }

        Viewer Viewer = viewerConverter.viewerDtoToViewer(ViewerDto);
        logger.debug("Converted Viewer entity => {} from DTO => {}", Viewer, ViewerDto);
        Viewer.setId(id);
        Viewer = viewerRepository.save(Viewer);
        logger.debug("Viewer record updated in DB=>{}", Viewer);
        ViewerDto dto = viewerConverter.viewerToViewerDto(Viewer);
        logger.debug("Converted DTO => {} from Viewer entity", dto);
        return dto;
    }

    /**
     * This method delete the {@link Viewer} entity identified by the given id
     *
     * @param id - the id of the entity to be deleted. Must not be null.
     * @return true of false
     */
    @Override
    public Boolean delete(Long id) {
        logger.debug("Into delete entity service method with id => {}", id);
        // Validate.
        if (viewerRepository.findById(id).isEmpty()) {
            logger.error("Resource doesn't exist!");
            throw new ResourceNotFoundException("Resource doesn't exist!");
        }

        Viewer viewer = viewerRepository.getById(id);
        logger.debug("Fetching Viewer entity by id => {} from DB using repository", id);

        //delete viewer
        viewer.setIsActive(false);
        viewerRepository.save(viewer);
        logger.debug("Viewer entity deleted from DB=>{}", viewer);
        return true;

    }
}
