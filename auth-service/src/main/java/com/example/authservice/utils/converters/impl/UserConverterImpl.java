package com.example.authservice.utils.converters.impl;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.authservice.dtos.commons.UserDto;
import com.example.authservice.dtos.requests.UserRegistrationDto;
import com.example.authservice.entities.User;
import com.example.authservice.utils.converters.UserConverter;
import org.modelmapper.ModelMapper;

/**
 * This class implement an interface {@link UserConverter}
 * It contains conversion logic for {@link User}, {@link UserDto} and {@link UserRegistrationDto}
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
public class UserConverterImpl implements UserConverter {

    private final ModelMapper modelMapper;

    public UserConverterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * This method convert {@link User} to {@link UserRegistrationDto}
     *
     * @param user - user details
     * @return {@link UserRegistrationDto}
     */
    @Override
    public UserRegistrationDto userToUserRegDto(User user) {
        return modelMapper.map(user, UserRegistrationDto.class);
    }

    /**
     * This method convert {@link UserRegistrationDto} to {@link User}
     *
     * @param userRegistrationDto - user registration details
     * @return {@link User}
     */
    @Override
    public User userRegDtoToUser(UserRegistrationDto userRegistrationDto) {
        return modelMapper.map(userRegistrationDto, User.class);
    }

    /**
     * This method convert {@link User} to {@link UserDto}
     *
     * @param user - user details
     * @return {@link UserDto}
     */
    @Override
    public UserDto userToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    /**
     * This method convert {@link UserDto} to {@link User}
     *
     * @param userDto - user dto details
     * @return {@link User}
     */
    @Override
    public User userDtoToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    /**
     * This method convert {@link UserDto} to {@link User}
     *
     * @param userDto - user dto details
     * @param user    - user details
     * @return {@link User}
     */
    @Override
    public User toUpdateUser(UserDto userDto, User user) {
        return null;
    }
}
