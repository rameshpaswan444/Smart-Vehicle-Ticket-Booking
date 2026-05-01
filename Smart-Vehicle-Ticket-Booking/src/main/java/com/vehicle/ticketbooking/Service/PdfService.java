package com.vehicle.ticketbooking.Service;

import java.io.ByteArrayInputStream;

public interface PdfService {

    ByteArrayInputStream generateTicketPdf(String ticketNumber);
}
