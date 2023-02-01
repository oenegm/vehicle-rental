package com.project.vehiclerental.controller;

import com.project.vehiclerental.dto.VehicleDto;
import com.project.vehiclerental.entity.Vehicle;
import com.project.vehiclerental.service.VehicleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getVehicles() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vehicleService.getAllVehicles());
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleDto> findVehicle(@PathVariable("vehicleId") Long vehicleId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vehicleService.findVehicleById(vehicleId));
    }

    @PostMapping
    public ResponseEntity<VehicleDto> addVehicle(@Valid @RequestBody VehicleDto vehicleDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vehicleService.saveVehicle(vehicleDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @Valid @RequestBody Vehicle vehicle) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vehicleService.updateVehicle(id, vehicle));
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<VehicleDto> deleteVehicle(@PathVariable("vehicleId") Long vehcileId) {
        vehicleService.deleteVehicle(vehcileId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(vehicleService.deleteVehicle(vehcileId));
    }
}
