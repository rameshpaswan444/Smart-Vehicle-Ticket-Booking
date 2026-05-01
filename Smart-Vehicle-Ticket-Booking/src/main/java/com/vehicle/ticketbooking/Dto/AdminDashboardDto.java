package com.vehicle.ticketbooking.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminDashboardDto {

    private Long totalUsers;
    private Long totalVehicles;
    private Long totalBookings;
    private Double totalRevenue;
}
