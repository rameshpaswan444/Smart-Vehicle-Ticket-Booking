package com.vehicle.ticketbooking.Controller;

import com.vehicle.ticketbooking.Dto.RouteRequestDto;
import com.vehicle.ticketbooking.Entity.Route;
import com.vehicle.ticketbooking.Service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/add")
    public ResponseEntity<String> addRoute(
            @RequestBody RouteRequestDto request) {

        return ResponseEntity.ok(
                routeService.addRoute(request)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<Route>> getAllRoutes() {

        return ResponseEntity.ok(
                routeService.getAllRoutes()
        );
    }

    @GetMapping("/search")
    public ResponseEntity<List<Route>> searchRoutes(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate travelDate
    ) {

        return ResponseEntity.ok(
                routeService.searchRoutes(
                        source,
                        destination,
                        travelDate
                )
        );
    }
}
