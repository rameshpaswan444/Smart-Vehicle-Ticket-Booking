package com.vehicle.ticketbooking.ServiceImpl;

import com.vehicle.ticketbooking.Dto.AdminDashboardDto;
import com.vehicle.ticketbooking.Repository.BookingRepository;
import com.vehicle.ticketbooking.Repository.UserRepository;
import com.vehicle.ticketbooking.Repository.VehicleRepository;
import com.vehicle.ticketbooking.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.core.Base64Variant;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public AdminDashboardDto getDashboardStats() {

        Long totalUsers = userRepository.count();

        Long totalVehicles = vehicleRepository.count();

        Long totalBookings = bookingRepository.count();

        Double totalRevenue = bookingRepository.getTotalRevenue();

        if (totalRevenue == null) {
            totalRevenue = 0.0;
        }

        return new AdminDashboardDto(
                totalUsers,
                totalVehicles,
                totalBookings,
                totalRevenue
        );
    }

}
