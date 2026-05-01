package com.vehicle.ticketbooking.Controller;

import com.vehicle.ticketbooking.Dto.TicketResponseDto;
import com.vehicle.ticketbooking.Service.PdfService;
import com.vehicle.ticketbooking.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;



@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private PdfService pdfService;

    @GetMapping("/{ticketNumber}")
    public ResponseEntity<TicketResponseDto> getTicket(
            @PathVariable String ticketNumber) {

        return ResponseEntity.ok(
                ticketService.getTicketByNumber(ticketNumber)
        );
    }
    @GetMapping("/pdf/{ticketNumber}")
    public ResponseEntity<InputStreamResource> downloadTicketPdf(
            @PathVariable String ticketNumber) {

        ByteArrayInputStream pdf =
                pdfService.generateTicketPdf(ticketNumber);

        HttpHeaders headers = new HttpHeaders();
        headers.add(
                "Content-Disposition",
                "inline; filename=ticket.pdf"
        );

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }
}
