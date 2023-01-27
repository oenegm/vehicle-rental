package com.project.vehiclerental.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.project.vehiclerental.entity.Brand} entity
 */
@Data
public class BrandDto implements Serializable {
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String country;
    private String imageURL;
}