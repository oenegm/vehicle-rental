package com.project.vehiclerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.vehiclerental.model.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

}