package com.vehicle.ticketbooking.Dto;

import lombok.Data;

@Data
public class VehicleRequestDto {

    private String vehicleNumber;
    private String vehicleType;
    private Integer totalSeats;
    private String driverName;
    private String driverContact;
}
