package com.project.vehiclerental.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.vehiclerental.enums.Gender;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.project.vehiclerental.entity.User} entity
 */
@Data
public class UserDto implements Serializable {
    private Long id;
    private String username;
    private String name;
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String phoneNumber;
    private Gender gender;
}