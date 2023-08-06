package com.project.vehiclerental.controller;

import com.project.vehiclerental.dto.RentalDto;
import com.project.vehiclerental.service.RentalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;


    @GetMapping
    public ResponseEntity<List<RentalDto>> getRentals() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(rentalService.getAllRentals());
    }

    @GetMapping("{id}")
    public ResponseEntity<RentalDto> getRental(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(rentalService.findRentalById(id));
    }

    @PostMapping
    public ResponseEntity<RentalDto> createRental(@Valid @RequestBody RentalDto rentalDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(rentalService.saveRental(rentalDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<RentalDto> updateRental(
            @PathVariable Long id,
            @Valid @RequestBody RentalDto rentalDto
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(rentalService.updateRental(id, rentalDto));
    }

    @DeleteMapping("{rentalId}")
    public ResponseEntity<Void> deleteRental(@PathVariable long rentalId) {
        rentalService.deleteRental(rentalId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
