package com.example.movieservice.dtos.commons;

/*
 * Copyright (c) 2024 Wasif.
 */

//import io.swagger.annotations.ApiModel;

import com.example.movieservice.entities.enums.MovieGenre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * This class is a dto class with 8 member variables.
 * It defines the details of different movie.
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
public class MovieDto {
    /**
     * It represents the unique id of every record.
     */
    private Long id;
    /**
     * It represents movie name.
     */
    private String name;
    /**
     * It represents release date of the movie
     */
    private Date releaseDate;
    /**
     * It represents the description of the movie
     */
    private String description;
    /**
     * It represents the actor name
     */
    private String actorName;
    /**
     * It represents the actress name
     */
    private String actressName;
    /**
     * It represents genre of the movie
     */
    private MovieGenre movieGenre;
    /**
     * It represents viewer is available or not.
     */
    private Boolean isActive = true;
}
