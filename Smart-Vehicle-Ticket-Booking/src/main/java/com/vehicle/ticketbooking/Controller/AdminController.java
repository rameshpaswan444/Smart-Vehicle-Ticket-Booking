package com.vehicle.ticketbooking.Controller;

import com.vehicle.ticketbooking.Dto.AdminDashboardDto;
import com.vehicle.ticketbooking.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/dashboard")
    public ResponseEntity<AdminDashboardDto> getDashboard() {

        return ResponseEntity.ok(
                adminService.getDashboardStats()
        );
    }
}
