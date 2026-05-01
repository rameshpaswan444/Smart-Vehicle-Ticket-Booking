package com.vehicle.ticketbooking.Jwt;

import com.vehicle.ticketbooking.Dto.AuthResponseDto;
import com.vehicle.ticketbooking.Dto.LoginRequestDto;
import com.vehicle.ticketbooking.Dto.RegisterRequestDto;

public interface AuthService {

    String register(RegisterRequestDto request);

    AuthResponseDto login(LoginRequestDto request);
}
