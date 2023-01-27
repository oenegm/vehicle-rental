package com.project.vehiclerental.entity;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.project.vehiclerental.enums.RentalStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "vehicle_id",
            referencedColumnName = "id",
            nullable = false)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIncludeProperties("id")
    @JsonUnwrapped(prefix = "vehicle_")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "renter_id",
            referencedColumnName = "id",
            nullable = false)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIncludeProperties("id")
    @JsonUnwrapped(prefix = "renter_")
    private User renter;

    @Column(name = "request_date")
    private LocalDateTime requestDate;

    @Column(name = "rent_date")
    private LocalDateTime rentDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "rental_status")
    private RentalStatus rentalStatus;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "cost")
    private Double cost;

//    @PrePersist
//    private void setCost() {
//        this.cost = this.vehicle.getPricePerDay() * this.duration;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Rental rental = (Rental) o;
        return id != null && Objects.equals(id, rental.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
