package com.example.authservice.configuration;

/*
 * Copyright (c) 2024 Wasif.
 */

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    /**
     * This method define {@link Docket} bean.
     * It returns an instance of ApiSelectorBuilder
     * which control the endpoints exposed by Swagger
     *
     * @return {@link Docket}
     */
    public Docket swaggerConfigurationDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/**"))
                .apis(RequestHandlerSelectors.basePackage("com.example.authservice"))
                .build()
                .apiInfo(apiDetails());
    }

    /**
     * This method add custom information about the api.
     *
     * @return {@link ApiInfo}
     */
    private ApiInfo apiDetails() {
        return new ApiInfo(
                "User Service",
                "SpringBoot project for User service",
                "1.0",
                "Free to user",
                new springfox.documentation.service.Contact("Movie Hub", "https://moviehub.com", "ops@moviehub.com"),
                "API License",
                "https://abc.com",
                Collections.emptyList());
    }
}
