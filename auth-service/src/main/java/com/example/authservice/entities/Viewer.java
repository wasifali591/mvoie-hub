package com.example.authservice.entities;

/*
 * Copyright (c) 2024 Wasif.
 */

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

/**
 * This class is an entity class with 8 member variables.
 * It defines the details of different viewer.
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
public class Viewer {
    /**
     * It represents the unique id of every record.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ApiModelProperty(name = "id", notes = "User Id", required = true, value = "1")
    private Long id;
    /**
     * It represents users name.
     */
//    @ApiModelProperty(name = "name", notes = "User name", required = true, value = "abc")
    private String name;
    /**
     * It represents users email.
     */
    @Column(length = 70)
//    @ApiModelProperty(name = "email", notes = "User email", required = true, value = "abc@mail.com")
    private String email;
    /**
     * It represents viewer username.
     */
//    @ApiModelProperty(name = "userName", notes = "User username", required = true, value = "abc")
    private String username;
    /**
     * It represents viewer password.
     */
//    @ApiModelProperty(name = "password", notes = "User password", required = true, value = "abc")
    private String password;
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
