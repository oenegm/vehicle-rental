package com.project.vehiclerental.entity;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.project.vehiclerental.enums.FuelType;
import com.project.vehiclerental.enums.TransmissionType;
import com.project.vehiclerental.enums.VehicleStatus;
import com.project.vehiclerental.enums.VehicleType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "owner_id",
            referencedColumnName = "id",
            nullable = false)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIncludeProperties("id")
    @JsonUnwrapped(prefix = "owner_")
    private User owner;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "brand_id",
            referencedColumnName = "id",
            nullable = false)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIncludeProperties("id")
    @JsonUnwrapped(prefix = "brand_")
    private Brand brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;

    @Column(name = "image_url")
    private String imageURL;

    @Column(name = "address")
    private String address;

    @Column(name = "registration_number")
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

    @Column(name = "price_per_day")
    @Min(1)
    private Double pricePerDay;

    @Column(name = "rating")
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
