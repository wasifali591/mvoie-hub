package com.example.authservice.dtos.commons;

/*
 * Copyright (c) 2024 Wasif.
 */

//import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is a dto class with 4 member variables.
 * It defines the details of different user.
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
public class ViewerDto {
    /**
     * It represents the unique id of every record.
     */
    private Long id;
    /**
     * It represents users name.
     */
    private String name;
    /**
     * It represents users email.
     */
    private String email;
    /**
     * It represents users is available or not.
     */
    private Boolean isActive;
}
