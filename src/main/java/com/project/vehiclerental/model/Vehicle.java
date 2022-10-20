package com.project.vehiclerental.model;

import com.project.vehiclerental.model.enums.FuelType;
import com.project.vehiclerental.model.enums.TransmissionType;
import com.project.vehiclerental.model.enums.VehicleStatus;
import com.project.vehiclerental.model.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "owner_ID",
            referencedColumnName = "id",
            nullable = false)
    private User owner;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "maker_ID",
            referencedColumnName = "id",
            nullable = false)
    private Brand brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "image_url", nullable = false)
    private String imageURL;

    @Column(name = "address")
    private String address;

    @Column(name = "registration_number", nullable = false)
    private String registrationNumber;

    @Column(name = "color")
    private String color;

    @Column(name = "number_of_seats")
    private String numberOfSeats;

    @Column(name = "number_of_doors")
    private String numberOfDoors;

    @Column(name = "vehicle_type")
    private VehicleType vehicleType;

    @Column(name = "transmission_type")
    private TransmissionType transmissionType;

    @Column(name = "fuel_type")
    private FuelType fuelType;

    @Column(name = "vehicle_status")
    private VehicleStatus vehicleStatus;

    @Column(name = "price_per_day", nullable = false)
    @Min(1)
    private Integer priceByDay;

    @Column(name = "rating")
    private Float rating;
}
