package com.vehicle.ticketbooking.Controller;

import com.vehicle.ticketbooking.Dto.BookingRequestDto;
import com.vehicle.ticketbooking.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(
            @RequestBody BookingRequestDto request) {

        return ResponseEntity.ok(
                bookingService.bookTicket(request)
        );
    }
}
