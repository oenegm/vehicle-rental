package com.project.vehiclerental.entity;

import com.project.vehiclerental.enums.FuelType;
import com.project.vehiclerental.enums.TransmissionType;
import com.project.vehiclerental.enums.VehicleStatus;
import com.project.vehiclerental.enums.VehicleType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "owner_id",
            referencedColumnName = "id",
            nullable = false
    )
    private User owner;

    @ManyToOne
    @JoinColumn(
            name = "brand_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Brand brand;

    @OneToMany(mappedBy = "vehicle")
    private List<Rental> rentals;

    private String model;

    private Integer year;

    private String imageURL;

    private String address;

    private String registrationNumber;

    private String color;

    private String numberOfSeats;

    private String numberOfDoors;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Enumerated(EnumType.STRING)
    private TransmissionType transmissionType;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    private VehicleStatus vehicleStatus;

    @Min(1)
    private Double pricePerDay;

    private Float rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Vehicle vehicle = (Vehicle) o;
        return id != null && Objects.equals(id, vehicle.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
