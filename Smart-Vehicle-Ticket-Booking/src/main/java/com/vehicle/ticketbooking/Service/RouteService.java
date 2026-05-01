package com.vehicle.ticketbooking.Service;

import com.vehicle.ticketbooking.Dto.RouteRequestDto;
import com.vehicle.ticketbooking.Entity.Route;

import java.time.LocalDate;
import java.util.List;

public interface RouteService {

    String addRoute(RouteRequestDto request);

    List<Route> getAllRoutes();

    List<Route> searchRoutes(
            String source,
            String destination,
            LocalDate travelDate
    );
}
