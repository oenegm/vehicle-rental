package com.project.vehiclerental.models;

import com.project.vehiclerental.enums.RentalStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rentals")
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

    @Column(name = "rating")
    private Float rating;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @PrePersist
    private void setCost() {
        this.cost = this.vehicle.getPricePerDay() * this.duration;
    }
}
