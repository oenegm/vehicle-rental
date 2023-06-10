package com.project.vehiclerental.entity;

import com.project.vehiclerental.enums.RentalStatus;
import lombok.*;
import org.hibernate.Hibernate;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(
            name = "vehicle_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(
            name = "renter_id",
            referencedColumnName = "id",
            nullable = false
    )
    private User renter;

    private LocalDateTime requestDate;

    private LocalDateTime rentDate;

    private LocalDateTime returnDate;

    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus;

    private Integer duration;

    private Float rating;

    private Double cost;

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
