package com.hotel.reservation.repository;

import com.hotel.reservation.model.Habitacion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class HabitacionRepository {

    private final Map<Long, Habitacion> habitaciones = new ConcurrentHashMap<>();

    public List<Habitacion> findAll() {
        return new ArrayList<>(habitaciones.values());
    }

    public Optional<Habitacion> findById(Long id) {
        return Optional.ofNullable(habitaciones.get(id));
    }

    public Habitacion save(Habitacion habitacion) {
        habitaciones.put(habitacion.getId(), habitacion);
        return habitacion;
    }

    public void saveAll(List<Habitacion> listaHabitaciones) {
        for (Habitacion habitacion : listaHabitaciones) {
            habitaciones.put(habitacion.getId(), habitacion);
        }
    }
}

