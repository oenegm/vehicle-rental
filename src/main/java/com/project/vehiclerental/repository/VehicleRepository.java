package com.project.vehiclerental.repository;

import com.project.vehiclerental.entity.User;
import com.project.vehiclerental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findAllByOwner(User owner);
}
