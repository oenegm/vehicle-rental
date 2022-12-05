package com.project.vehiclerental.controllers;

import com.project.vehiclerental.models.Rental;
import com.project.vehiclerental.services.RentalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rentals")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public ResponseEntity<List<Rental>> getRentals() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(rentalService.getAllRentals());
    }

    @GetMapping("{id}")
    public ResponseEntity<Rental> findRentalByID(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(rentalService.findRentalById(id));
    }

    @PostMapping
    public ResponseEntity<Rental> addRental(@Valid @RequestBody Rental rental) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(rentalService.saveRental(rental));
    }

    @PutMapping("{id}")
    public ResponseEntity<Rental> updateRental(@PathVariable Long id, @Valid @RequestBody Rental rental) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(rentalService.updateRental(id, rental));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteRental(@PathVariable long id) {
        rentalService.deleteRental(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
