package com.vehicle.ticketbooking.Controller;

import com.vehicle.ticketbooking.Dto.VehicleRequestDto;
import com.vehicle.ticketbooking.Entity.Vehicle;
import com.vehicle.ticketbooking.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add")
    public ResponseEntity<String> addVehicle(@RequestBody VehicleRequestDto request){

        return ResponseEntity.ok(vehicleService.addVehicle(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateVehicle(
            @PathVariable Long id,
            @RequestBody VehicleRequestDto request) {

        return ResponseEntity.ok(
                vehicleService.updateVehicle(id, request)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVehicle(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                vehicleService.deleteVehicle(id)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {

        return ResponseEntity.ok(
                vehicleService.getAllVehicles()
        );
    }
}
