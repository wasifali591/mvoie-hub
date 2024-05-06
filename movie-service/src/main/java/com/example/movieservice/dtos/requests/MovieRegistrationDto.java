package com.example.movieservice.dtos.requests;

/*
 * Copyright (c) 2024 Wasif.
 */

//import io.swagger.annotations.ApiModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is a dto class of viewer registration
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
//@ApiModel(description = "It contains business registration details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieRegistrationDto {
    /**
     * It represents movie name.
     */
    private String name;
}
