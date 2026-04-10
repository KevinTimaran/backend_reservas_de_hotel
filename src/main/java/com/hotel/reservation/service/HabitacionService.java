package com.hotel.reservation.service;

import com.hotel.reservation.enums.EstadoHabitacion;
import com.hotel.reservation.exception.ResourceNotFoundException;
import com.hotel.reservation.model.Habitacion;
import com.hotel.reservation.repository.HabitacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;

    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    public List<Habitacion> obtenerTodas() {
        return habitacionRepository.findAll();
    }

    public Habitacion obtenerPorId(Long id) {
        return habitacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habitacion no encontrada con id: " + id));
    }

    public Habitacion guardar(Habitacion habitacion) {
        // TODO: Agregar validaciones de negocio antes de guardar.
        return habitacionRepository.save(habitacion);
    }

    public Habitacion actualizarEstado(Long id, EstadoHabitacion estado) {
        Habitacion habitacion = obtenerPorId(id);
        // TODO: Validar transiciones de estado permitidas.
        habitacion.setEstado(estado);
        return habitacionRepository.save(habitacion);
    }
}

