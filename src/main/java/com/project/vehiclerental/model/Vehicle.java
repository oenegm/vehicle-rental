package com.project.vehiclerental.model;

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
    private Maker maker;

    @Column(name = "model", nullable = false)
    private String model;

    // TODO: add vehicle type (enum)

    @Column(name = "image_url", nullable = false)
    private String imageURL;

    @Column(name = "address")
    private String address;

    @Column(name = "registration_number", nullable = false)
    private String registerationNumber;

    @Column(name = "color")
    private String color;

    @Column(name = "number_of_seats")
    private String numberOfSeats;

    @Column(name = "number_of_doors")
    private String numberOfDoors;

    // TODO: add transmission type (enum)

    // TODO: add fuel type (enum)

    // TODO: status (enum)

    @Column(name = "price_per_day", nullable = false)
    @Min(1)
    private Integer priceByDay;

    @Column(name = "rating")
    private Float rating;
}
