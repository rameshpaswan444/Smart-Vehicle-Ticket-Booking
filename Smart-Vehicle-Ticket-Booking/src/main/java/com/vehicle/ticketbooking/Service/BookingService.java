package com.vehicle.ticketbooking.Service;

import com.vehicle.ticketbooking.Dto.BookingRequestDto;

public interface BookingService {

    String bookTicket(BookingRequestDto request);
}
