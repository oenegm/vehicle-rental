package com.project.vehiclerental.service;

import com.project.vehiclerental.exception.VehicleNotFoundException;
import com.project.vehiclerental.entity.Vehicle;
import com.project.vehiclerental.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle findVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    //TODO: Implement custom exceptions
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle oldVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(id));

        oldVehicle.setOwner(vehicle.getOwner());
        oldVehicle.setBrand(vehicle.getBrand());
        oldVehicle.setModel(vehicle.getModel());
        oldVehicle.setImageURL(vehicle.getImageURL());
        oldVehicle.setAddress(vehicle.getAddress());
        oldVehicle.setRegistrationNumber(vehicle.getRegistrationNumber());
        oldVehicle.setColor(vehicle.getColor());
        oldVehicle.setNumberOfSeats(vehicle.getNumberOfSeats());
        oldVehicle.setNumberOfDoors(vehicle.getNumberOfDoors());
        oldVehicle.setVehicleType(vehicle.getVehicleType());
        oldVehicle.setTransmissionType(vehicle.getTransmissionType());
        oldVehicle.setFuelType(vehicle.getFuelType());
        oldVehicle.setVehicleStatus(vehicle.getVehicleStatus());
        oldVehicle.setPricePerDay(vehicle.getPricePerDay());
        oldVehicle.setRating(vehicle.getRating());

        return vehicleRepository.save(oldVehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
