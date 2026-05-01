package com.vehicle.ticketbooking.Service;

import com.vehicle.ticketbooking.Dto.TicketResponseDto;

public interface TicketService {

    TicketResponseDto getTicketByNumber(String ticketNumber);
}
