package com.project.vehiclerental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.vehiclerental.models.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

}