package com.project.vehiclerental.service;

import com.project.vehiclerental.exception.RentalNotFoundException;
import com.project.vehiclerental.entity.Rental;
import com.project.vehiclerental.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental findRentalById(Long id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public Rental updateRental(Long id, Rental rental) {
        Rental oldRental = rentalRepository.findById(id)
                .orElseThrow(() -> new RentalNotFoundException(id));

        BeanUtils.copyProperties(rental, oldRental, "id");

        return rentalRepository.save(oldRental);
    }

    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }
}
