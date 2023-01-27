package com.project.vehiclerental.service;

import com.project.vehiclerental.exception.RentalNotFoundException;
import com.project.vehiclerental.entity.Rental;
import com.project.vehiclerental.repository.RentalRepository;
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

    //TODO: Implement custom exceptions
    public Rental updateRental(Long id, Rental rental) {
        Rental oldRental = rentalRepository.findById(id)
                .orElseThrow(() -> new RentalNotFoundException(id));

        oldRental.setVehicle(rental.getVehicle());
        oldRental.setRenter(rental.getRenter());
        oldRental.setRequestDate(rental.getRequestDate());
        oldRental.setRentDate(rental.getRentDate());
        oldRental.setReturnDate(rental.getReturnDate());
        oldRental.setRentalStatus(rental.getRentalStatus());
        oldRental.setDuration(rental.getDuration());
        oldRental.setRating(rental.getRating());
        oldRental.setCost(rental.getCost());

        return rentalRepository.save(oldRental);
    }

    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }
}
