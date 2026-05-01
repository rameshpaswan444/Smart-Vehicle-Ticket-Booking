package com.vehicle.ticketbooking.Repository;

import com.vehicle.ticketbooking.Entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findBySourceAndDestinationAndTravelDate(
            String source,
            String destination,
            LocalDate travelDate
    );
}
