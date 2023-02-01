package com.project.vehiclerental.service;

import com.project.vehiclerental.dto.VehicleDto;
import com.project.vehiclerental.exception.BrandNotFoundException;
import com.project.vehiclerental.exception.VehicleNotFoundException;
import com.project.vehiclerental.entity.Vehicle;
import com.project.vehiclerental.mapper.VehicleMapper;
import com.project.vehiclerental.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VehicleService {

    private final VehicleMapper vehicleMapper;
    private final VehicleRepository vehicleRepository;

    public List<VehicleDto> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(vehicleMapper::toDto)
                .collect(Collectors.toList());
    }

    public VehicleDto findVehicleById(Long id) {
        return vehicleMapper.toDto(vehicleRepository.findById(id).orElseThrow(() -> new VehicleNotFoundException(id)));
    }

    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        return vehicleMapper.toDto(
                vehicleRepository.save(vehicleMapper.toEntity(vehicleDto)));
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle oldVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(id));

        BeanUtils.copyProperties(vehicle, oldVehicle, "id");

        return vehicleRepository.save(oldVehicle);
    }

    public VehicleDto deleteVehicle(Long id) {
        Vehicle deletedVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(id));

        vehicleRepository.delete(deletedVehicle);

        return vehicleMapper.toDto(deletedVehicle);
    }
}
