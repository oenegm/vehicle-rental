package com.project.vehiclerental.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.vehiclerental.enums.RentalStatus;
import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.project.vehiclerental.entity.Rental} entity
 */
@Data
public class RentalDto implements Serializable {
    private Long id;

    @NotNull
    private VehicleDto vehicle;

    @NotNull
    private UserDto renter;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime requestDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime rentDate;

    @Future
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime returnDate;

    private RentalStatus rentalStatus;
    private Integer duration;
    private Float rating;
    private Double cost;
}