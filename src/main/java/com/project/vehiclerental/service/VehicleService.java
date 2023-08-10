package com.project.vehiclerental.service;

import com.project.vehiclerental.dto.VehicleDto;
import com.project.vehiclerental.entity.Vehicle;
import com.project.vehiclerental.advice.exception.VehicleNotFoundException;
import com.project.vehiclerental.mapper.VehicleMapper;
import com.project.vehiclerental.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public List<VehicleDto> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(vehicleMapper::toDto)
                .toList();
    }

    public VehicleDto findVehicleById(Long id) {
        return vehicleMapper.toDto(vehicleRepository.findById(id).orElseThrow(() -> new VehicleNotFoundException(id)));
    }

    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        return vehicleMapper.toDto(
                vehicleRepository.save(vehicleMapper.toEntity(vehicleDto)));
    }

    public Vehicle updateVehicle(Long id, VehicleDto vehicleDto) {
        Vehicle oldVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(id));

        BeanUtils.copyProperties(vehicleDto, oldVehicle, "id");

        return vehicleRepository.save(oldVehicle);
    }

    public void deleteVehicle(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }
}
