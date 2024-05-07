package com.example.ratingservice.dtos.commons;

/*
 * Copyright (c) 2024 Wasif.
 */

//import io.swagger.annotations.ApiModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is a dto class with 2 member variables.
 * It defines the details of different rating.
 *
 * @author wasif
 * @version 1.0
 * @since 05/05/2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ApiModel(description = "It contains users details")
public class RatingDto {
    /**
     * It represents the unique id of every record.
     */
    private Long id;
    /**
     * It represents movie rating.
     */
    private int rating;

}
