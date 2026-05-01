package com.vehicle.ticketbooking.ServiceImpl;

import com.vehicle.ticketbooking.Dto.BookingRequestDto;
import com.vehicle.ticketbooking.Entity.Booking;
import com.vehicle.ticketbooking.Entity.Route;
import com.vehicle.ticketbooking.Entity.Ticket;
import com.vehicle.ticketbooking.Entity.Vehicle;
import com.vehicle.ticketbooking.Exception.ResourceNotFoundException;
import com.vehicle.ticketbooking.Repository.BookingRepository;
import com.vehicle.ticketbooking.Repository.RouteRepository;
import com.vehicle.ticketbooking.Repository.TicketRepository;
import com.vehicle.ticketbooking.Repository.VehicleRepository;
import com.vehicle.ticketbooking.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public String bookTicket(BookingRequestDto request) {

        Route route = routeRepository.findById(request.getRouteId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Route not found"));

        Vehicle vehicle = route.getVehicle();

        // Check available seats
        if (vehicle.getAvailableSeats() < request.getSeatNumbers().size()) {
            throw new ResourceNotFoundException("Not enough seats available");
        }

        // Prevent double booking
        List<Booking> existingBookings =
                bookingRepository.findByRoute(route);

        for (Booking booking : existingBookings) {
            for (String seat : booking.getSeatNumbers()) {
                if (request.getSeatNumbers().contains(seat)) {
                    throw new ResourceNotFoundException(
                            "Seat already booked: " + seat
                    );
                }
            }
        }

        Double totalFare =
                route.getFare() * request.getSeatNumbers().size();

        Booking booking = Booking.builder()
                .passengerName(request.getPassengerName())
                .passengerEmail(request.getPassengerEmail())
                .bookingTime(LocalDateTime.now())
                .totalFare(totalFare)
                .bookingStatus("CONFIRMED")
                .seatNumbers(request.getSeatNumbers())
                .route(route)
                .build();

        bookingRepository.save(booking);

        String ticketNumber =
                "TKT-" + System.currentTimeMillis();

        Ticket ticket = Ticket.builder()
                .ticketNumber(ticketNumber)
                .ticketStatus("ACTIVE")
                .booking(booking)
                .build();

        ticketRepository.save(ticket);

        // Reduce available seats
        vehicle.setAvailableSeats(
                vehicle.getAvailableSeats()
                        - request.getSeatNumbers().size()
        );

        vehicleRepository.save(vehicle);

        return "Ticket Booked Successfully. Ticket Number: " + ticketNumber;
    }
}
