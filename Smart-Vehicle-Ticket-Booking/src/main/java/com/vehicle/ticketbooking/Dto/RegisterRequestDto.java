package com.vehicle.ticketbooking.Dto;

import lombok.Data;

@Data
public class RegisterRequestDto {

    public String fullName;
    private String email;
    private String password;
}
