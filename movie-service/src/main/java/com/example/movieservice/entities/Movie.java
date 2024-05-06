package com.example.movieservice.entities;

/*
 * Copyright (c) 2024 Wasif.
 */

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

import com.example.movieservice.entities.enums.MovieGenre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

/**
 * This class is an entity class with 10 member variables.
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
@Entity
//@ApiModel(description = "It contains user details")
public class Movie {
    /**
     * It represents the unique id of every record.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ApiModelProperty(name = "id", notes = "User Id", required = true, value = "1")
    private Long id;
    /**
     * It represents movie name.
     */
//    @ApiModelProperty(name = "name", notes = "User name", required = true, value = "abc")
    private String name;
    /**
     * It represents release date of the movie
     */
    @Temporal(TemporalType.DATE)
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
    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private MovieGenre movieGenre;
    /**
     * It represents viewer is available or not.
     */
    @Builder.Default
//    @ApiModelProperty(name = "isActive", notes = "User is available or not ", required = true, value = "true/false")
    private Boolean isActive = true;
    /**
     * It represents record created date.
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
//    @ApiModelProperty(name = "createdDate", notes = "User created date", required = true, value = "00/00/0000")
    private Date createdDate;
    /**
     * It represents record updated date.
     */
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
//    @ApiModelProperty(name = "updatedDate", notes = "User updated date", required = true, value = "00/00/0000")
    private Date updatedDate;
}
