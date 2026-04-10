package com.hotel.reservation.service;

import com.hotel.reservation.exception.ResourceNotFoundException;
import com.hotel.reservation.model.Invoice;
import com.hotel.reservation.model.Reservation;
import com.hotel.reservation.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BillingService {

    private final InvoiceRepository invoiceRepository;

    public BillingService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice generateInvoice(Reservation reservation, double subtotal) {
        // TODO: Apply real tax rules by country and currency.
        double taxes = subtotal * 0.19;
        double total = subtotal + taxes;

        Invoice invoice = new Invoice();
        invoice.setReservationId(reservation.getId());
        invoice.setSubtotal(subtotal);
        invoice.setTaxes(taxes);
        invoice.setTotal(total);
        invoice.setIssuedAt(LocalDateTime.now());

        return invoiceRepository.save(invoice);
    }

    public Invoice getByReservationId(Long reservationId) {
        return invoiceRepository.findByReservationId(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found for reservation: " + reservationId));
    }
}



