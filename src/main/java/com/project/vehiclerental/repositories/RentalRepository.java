package com.project.vehiclerental.repositories;

import com.project.vehiclerental.models.User;
import com.project.vehiclerental.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.vehiclerental.models.Rental;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findAllByVehicle(Vehicle vehicle);

    List<Rental> findAllByRenter(User renter);
}