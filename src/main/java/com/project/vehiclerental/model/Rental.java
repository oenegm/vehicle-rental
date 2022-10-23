package com.project.vehiclerental.model;

import com.project.vehiclerental.model.enums.RentalStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "vehicle_ID",
            referencedColumnName = "id",
            nullable = false)
    private Vehicle vehicle;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_ID",
            referencedColumnName = "id",
            nullable = false)
    private User renter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "owner_ID",
            referencedColumnName = "id",
            nullable = false)
    private User owner;

    @Column(name = "request_date", nullable = false)
    private LocalDateTime requestDate;

    @Column(name = "rent_date", nullable = false)
    private LocalDateTime rentDate;

    @Column(name = "return_date", nullable = false)
    private LocalDateTime returnDate;

    @Column(name = "rental_status", nullable = false)
    private RentalStatus rentalStatus;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "rating", nullable = false)
    private Float rating;

    @Column(name = "cost", nullable = false)
    private Double cost;


}
