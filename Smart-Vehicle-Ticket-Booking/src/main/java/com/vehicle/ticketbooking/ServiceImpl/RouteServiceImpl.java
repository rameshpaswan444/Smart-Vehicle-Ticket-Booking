package com.vehicle.ticketbooking.ServiceImpl;

import com.vehicle.ticketbooking.Dto.RouteRequestDto;
import com.vehicle.ticketbooking.Entity.Route;
import com.vehicle.ticketbooking.Entity.Vehicle;
import com.vehicle.ticketbooking.Exception.ResourceNotFoundException;
import com.vehicle.ticketbooking.Repository.RouteRepository;
import com.vehicle.ticketbooking.Repository.VehicleRepository;
import com.vehicle.ticketbooking.Service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public String addRoute(RouteRequestDto request) {

        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle not found"));

        Route route = Route.builder()
                .source(request.getSource())
                .destination(request.getDestination())
                .travelDate(request.getTravelDate())
                .departureTime(request.getDepartureTime())
                .arrivalTime(request.getArrivalTime())
                .fare(request.getFare())
                .vehicle(vehicle)
                .build();

        routeRepository.save(route);

        return "Route Added Successfully";
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public List<Route> searchRoutes(
            String source,
            String destination,
            LocalDate travelDate
    ) {
        return routeRepository.findBySourceAndDestinationAndTravelDate(
                source,
                destination,
                travelDate
        );
    }
}