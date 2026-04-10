package com.hotel.reservation.repository;

import com.hotel.reservation.model.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InvoiceRepository {

    private final Map<Long, Invoice> invoices = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    public List<Invoice> findAll() {
        return new ArrayList<>(invoices.values());
    }

    public Optional<Invoice> findById(Long id) {
        return Optional.ofNullable(invoices.get(id));
    }

    public Optional<Invoice> findByReservationId(Long reservationId) {
        return invoices.values().stream().filter(invoice -> invoice.getReservationId().equals(reservationId)).findFirst();
    }

    public Invoice save(Invoice invoice) {
        if (invoice.getId() == null) {
            invoice.setId(sequence.getAndIncrement());
        }
        invoices.put(invoice.getId(), invoice);
        return invoice;
    }
}


