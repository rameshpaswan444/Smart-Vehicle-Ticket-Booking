package com.vehicle.ticketbooking.Dto;

import lombok.Data;

import java.util.List;

@Data
public class BookingRequestDto {

    private String passengerName;
    private String passengerEmail;
    private Long routeId;
    private List<String> seatNumbers;
}
