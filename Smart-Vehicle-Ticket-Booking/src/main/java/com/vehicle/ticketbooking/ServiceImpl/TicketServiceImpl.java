package com.vehicle.ticketbooking.ServiceImpl;

import com.vehicle.ticketbooking.Dto.TicketResponseDto;
import com.vehicle.ticketbooking.Entity.Booking;
import com.vehicle.ticketbooking.Entity.Ticket;
import com.vehicle.ticketbooking.Exception.ResourceNotFoundException;
import com.vehicle.ticketbooking.Repository.TicketRepository;
import com.vehicle.ticketbooking.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public TicketResponseDto getTicketByNumber(String ticketNumber) {


        Ticket ticket = ticketRepository.findByTicketNumber(ticketNumber)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ticket not found"));

        Booking booking = ticket.getBooking();

        return TicketResponseDto.builder()
                .ticketNumber(ticket.getTicketNumber())
                .passengerName(booking.getPassengerName())
                .passengerEmail(booking.getPassengerEmail())
                .source(booking.getRoute().getSource())
                .destination(booking.getRoute().getDestination())
                .seatNumbers(booking.getSeatNumbers())
                .totalFare(booking.getTotalFare())
                .bookingStatus(booking.getBookingStatus())
                .ticketStatus(ticket.getTicketStatus())
                .build();
    }
}
