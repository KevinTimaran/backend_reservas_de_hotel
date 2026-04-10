package com.hotel.reservation.repository;

import com.hotel.reservation.model.Reserva;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ReservaRepository {

    private final Map<Long, Reserva> reservas = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    public List<Reserva> findAll() {
        return new ArrayList<>(reservas.values());
    }

    public Optional<Reserva> findById(Long id) {
        return Optional.ofNullable(reservas.get(id));
    }

    public Reserva save(Reserva reserva) {
        if (reserva.getId() == null) {
            reserva.setId(sequence.getAndIncrement());
        }
        reservas.put(reserva.getId(), reserva);
        return reserva;
    }
}

