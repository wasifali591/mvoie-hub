package com.example.authservice.dtos.requests;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ApiModel(description = "It contains business registration details")
public class ViewerRegistrationDto {
    /**
     * It represents users username.
     */
    private String username;
    /**
     * It represents users password.
     */
    private String password;
}
