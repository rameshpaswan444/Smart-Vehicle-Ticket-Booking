package com.vehicle.ticketbooking.Service;

import com.vehicle.ticketbooking.Dto.VehicleRequestDto;
import com.vehicle.ticketbooking.Entity.Vehicle;

import java.util.List;

public interface VehicleService {

    String addVehicle(VehicleRequestDto request);
    String updateVehicle(Long id, VehicleRequestDto request);
    String deleteVehicle(Long id);

    List<Vehicle> getAllVehicles();
}
