package com.example.ratingservice.entities;

/*
 * Copyright (c) 2024 Wasif.
 */

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

/**
 * This class is an entity class with 5 member variables.
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
@Entity
//@ApiModel(description = "It contains user details")
public class Rating {
    /**
     * It represents the unique id of every record.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ApiModelProperty(name = "id", notes = "User Id", required = true, value = "1")
    private Long id;
    /**
     * It represents movie rating.
     */
//    @ApiModelProperty(name = "name", notes = "User name", required = true, value = "abc")
    @Min(value = 0, message = "Rating must be at least 0")
    @Max(value = 10, message = "Rating must be at most 10")
    private int rating;
    /**
     * It represents rating is available or not.
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
