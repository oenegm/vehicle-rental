package com.project.vehiclerental.services;

import com.project.vehiclerental.models.Rental;
import com.project.vehiclerental.repositories.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental findRentalById(Long id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    //TODO: Implement updateRental method
    public Rental updateRental(Long id, Rental rental) {
        return rentalRepository.save(rental);
    }

    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }
}
