package com.project.vehiclerental.repository;

import com.project.vehiclerental.entity.Rental;
import com.project.vehiclerental.entity.User;
import com.project.vehiclerental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findAllByVehicle(Vehicle vehicle);

    List<Rental> findAllByRenter(User renter);

    List<Rental> findAllByVehicleOwner(User owner);
}