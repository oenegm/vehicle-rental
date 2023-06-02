package com.project.vehiclerental.dto;

import com.project.vehiclerental.enums.FuelType;
import com.project.vehiclerental.enums.TransmissionType;
import com.project.vehiclerental.enums.VehicleStatus;
import com.project.vehiclerental.enums.VehicleType;
import lombok.Data;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * A DTO for the {@link com.project.vehiclerental.entity.Vehicle} entity
 */
@Data
public class VehicleDto implements Serializable {
    private final Long id;
    private final UserDto owner;
    private final BrandDto brand;
    private final String model;
    private final Integer year;
    private final String imageURL;
    private final String address;
    private final String registrationNumber;
    private final String color;
    private final String numberOfSeats;
    private final String numberOfDoors;
    private final VehicleType vehicleType;
    private final TransmissionType transmissionType;
    private final FuelType fuelType;
    private final VehicleStatus vehicleStatus;
    @Min(1)
    private final Double pricePerDay;
    private final Float rating;
}