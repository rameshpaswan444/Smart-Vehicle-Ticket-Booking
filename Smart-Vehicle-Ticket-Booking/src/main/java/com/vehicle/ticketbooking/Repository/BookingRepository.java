package com.vehicle.ticketbooking.Repository;

import com.vehicle.ticketbooking.Entity.Booking;
import com.vehicle.ticketbooking.Entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByRoute(Route route);

    @Query("SELECT SUM(b.totalFare) FROM Booking b")
    Double getTotalRevenue();
}
