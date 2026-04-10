package com.hotel.reservation.repository;

import com.hotel.reservation.model.Factura;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FacturaRepository {

    private final Map<Long, Factura> facturas = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    public List<Factura> findAll() {
        return new ArrayList<>(facturas.values());
    }

    public Optional<Factura> findById(Long id) {
        return Optional.ofNullable(facturas.get(id));
    }

    public Optional<Factura> findByReservaId(Long reservaId) {
        return facturas.values().stream().filter(f -> f.getReservaId().equals(reservaId)).findFirst();
    }

    public Factura save(Factura factura) {
        if (factura.getId() == null) {
            factura.setId(sequence.getAndIncrement());
        }
        facturas.put(factura.getId(), factura);
        return factura;
    }
}

