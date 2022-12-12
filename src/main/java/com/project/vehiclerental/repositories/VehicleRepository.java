package com.project.vehiclerental.repositories;

import com.project.vehiclerental.models.User;
import com.project.vehiclerental.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findAllByOwner(User owner);
}
