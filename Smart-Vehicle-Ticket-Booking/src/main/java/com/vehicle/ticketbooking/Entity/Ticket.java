package com.vehicle.ticketbooking.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticketNumber;

    private String ticketStatus;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
