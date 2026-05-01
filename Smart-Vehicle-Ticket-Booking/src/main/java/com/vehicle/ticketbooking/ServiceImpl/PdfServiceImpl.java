package com.vehicle.ticketbooking.ServiceImpl;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.vehicle.ticketbooking.Entity.Booking;
import com.vehicle.ticketbooking.Entity.Ticket;
import com.vehicle.ticketbooking.Exception.ResourceNotFoundException;
import com.vehicle.ticketbooking.Repository.TicketRepository;
import com.vehicle.ticketbooking.Service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfServiceImpl implements PdfService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public ByteArrayInputStream generateTicketPdf(String ticketNumber) {

        Ticket ticket = ticketRepository.findByTicketNumber(ticketNumber)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ticket not found"));

        Booking booking = ticket.getBooking();

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(document, out);
            document.open();

            document.add(new Paragraph(" SMART VEHICLE TICKET BOOKING SYSTEM"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Ticket Number: " + ticket.getTicketNumber()));
            document.add(new Paragraph("Passenger Name: " + booking.getPassengerName()));
            document.add(new Paragraph("Passenger Email: " + booking.getPassengerEmail()));
            document.add(new Paragraph("Source: " + booking.getRoute().getSource()));
            document.add(new Paragraph("Destination: " + booking.getRoute().getDestination()));
            document.add(new Paragraph("Seats: " + booking.getSeatNumbers()));
            document.add(new Paragraph("Total Fare: Rs. " + booking.getTotalFare()));
            document.add(new Paragraph("Booking Status: " + booking.getBookingStatus()));
            document.add(new Paragraph("Ticket Status: " + ticket.getTicketStatus()));
            document.add(new Paragraph("Booking Time: " + booking.getBookingTime()));

            document.close();

        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while generating PDF");
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

}
