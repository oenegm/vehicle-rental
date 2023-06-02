package com.project.vehiclerental.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
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