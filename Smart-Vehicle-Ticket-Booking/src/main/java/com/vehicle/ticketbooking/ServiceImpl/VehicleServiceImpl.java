package com.vehicle.ticketbooking.ServiceImpl;

import com.vehicle.ticketbooking.Dto.VehicleRequestDto;
import com.vehicle.ticketbooking.Entity.Vehicle;
import com.vehicle.ticketbooking.Exception.ResourceNotFoundException;
import com.vehicle.ticketbooking.Repository.VehicleRepository;
import com.vehicle.ticketbooking.Service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {


    @Autowired
    private  VehicleRepository vehicleRepository;

    @Override
    public String addVehicle(VehicleRequestDto request) {

        Vehicle vehicle = Vehicle.builder()
                .vehicleNumber(request.getVehicleNumber())
                .vehicleType(request.getVehicleType())
                .totalSeats(request.getTotalSeats())
                .availableSeats(request.getTotalSeats())
                .driverName(request.getDriverName())
                .driverContact(request.getDriverContact())
                .build();

        vehicleRepository.save(vehicle);

        return "Vehicle Added Successfully";
    }

    @Override
    public String updateVehicle(Long id, VehicleRequestDto request) {

        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Vehicle not found"));

        vehicle.setVehicleNumber(request.getVehicleNumber());
        vehicle.setVehicleType(request.getVehicleType());
        vehicle.setTotalSeats(request.getTotalSeats());
        vehicle.setDriverName(request.getDriverName());
        vehicle.setDriverContact(request.getDriverContact());

        vehicleRepository.save(vehicle);

        return "Vehicle Updated Successfully.";
    }

    @Override
    public String deleteVehicle(Long id) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        vehicleRepository.delete(vehicle);

        return "Vehicle Deleted Successfully";

    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
}
