package com.example.authservice.utils.converters;

/*
 * Copyright (c) 2024 Wasif.
 */

import com.example.authservice.dtos.commons.UserDto;
import com.example.authservice.dtos.requests.UserRegistrationDto;
import com.example.authservice.entities.User;

/**
 * This is a converter interface.
 * It used to map {@link User} entity class with {@link UserDto} and {@link UserRegistrationDto} dto class.
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
public interface UserConverter {
    /**
     * This method convert {@link User} to {@link UserRegistrationDto}
     *
     * @return {@link UserRegistrationDto}
     */
    UserRegistrationDto userToUserRegDto(User user);

    /**
     * This method convert {@link UserRegistrationDto} to {@link User}
     *
     * @return {@link User}
     */
    User userRegDtoToUser(UserRegistrationDto userRegistrationDto);

    /**
     * This method convert {@link User} to {@link UserDto}
     *
     * @return {@link UserDto}
     */
    UserDto userToUserDto(User user);

    /**
     * This method convert {@link UserDto} to {@link User}
     *
     * @return {@link User}
     */
    User userDtoToUser(UserDto userDto);

    /**
     * This method update existing {@link User} by {@link UserDto}
     *
     * @return {@link User}
     */
    User toUpdateUser(UserDto userDto, User user);
}
