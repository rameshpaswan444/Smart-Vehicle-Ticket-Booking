package com.vehicle.ticketbooking.Dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TicketResponseDto {

    private String ticketNumber;
    private String passengerName;
    private String passengerEmail;
    private String source;
    private String destination;
    private List<String> seatNumbers;
    private Double totalFare;
    private String bookingStatus;
    private String ticketStatus;
}
