package com.project.vehiclerental.mapper;

import com.project.vehiclerental.dto.VehicleDto;
import com.project.vehiclerental.entity.Vehicle;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface VehicleMapper {
    Vehicle toEntity(VehicleDto vehicleDto);

    VehicleDto toDto(Vehicle vehicle);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Vehicle partialUpdate(VehicleDto vehicleDto, @MappingTarget Vehicle vehicle);
}