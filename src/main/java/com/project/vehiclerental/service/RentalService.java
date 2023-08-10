package com.project.vehiclerental.service;

import com.project.vehiclerental.dto.RentalDto;
import com.project.vehiclerental.entity.Rental;
import com.project.vehiclerental.advice.exception.RentalNotFoundException;
import com.project.vehiclerental.mapper.RentalMapper;
import com.project.vehiclerental.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;

    public List<RentalDto> getAllRentals() {
        return rentalRepository.findAll()
                .stream().parallel()
                .map(rentalMapper::toDto)
                .toList();
    }

    public RentalDto findRentalById(Long id) {
        return rentalMapper.toDto(
                rentalRepository.findById(id)
                        .orElseThrow(() -> new RentalNotFoundException(id))
        );
    }

    public RentalDto saveRental(RentalDto rentalDto) {
        return rentalMapper.toDto(
                rentalRepository.save(
                        rentalMapper.toEntity(rentalDto)
                )
        );
    }

    public RentalDto updateRental(Long id, RentalDto rentalDto) {
        Rental oldRental = rentalRepository.findById(id)
                .orElseThrow(() -> new RentalNotFoundException(id));

        BeanUtils.copyProperties(rentalDto, oldRental, "id");

        return rentalMapper.toDto(rentalRepository.save(oldRental));
    }

    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }
}
