package com.hotel.reservation.config;

import com.hotel.reservation.enums.EstadoHabitacion;
import com.hotel.reservation.enums.TipoHabitacion;
import com.hotel.reservation.model.Habitacion;
import com.hotel.reservation.repository.HabitacionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner preloadRooms(HabitacionRepository habitacionRepository) {
        return args -> {
            if (!habitacionRepository.findAll().isEmpty()) {
                return;
            }

            List<Habitacion> habitaciones = new ArrayList<>();
            for (int i = 1; i <= 15; i++) {
                TipoHabitacion tipo;
                if (i <= 5) {
                    tipo = TipoHabitacion.SENCILLA;
                } else if (i <= 10) {
                    tipo = TipoHabitacion.DOBLE;
                } else {
                    tipo = TipoHabitacion.SUITE;
                }

                Habitacion habitacion = new Habitacion(
                        (long) i,
                        String.valueOf(100 + i),
                        tipo,
                        EstadoHabitacion.DISPONIBLE,
                        100.0 + (i * 10)
                );
                habitaciones.add(habitacion);
            }

            // TODO: Externalizar semilla de datos cuando exista una capa de persistencia real.
            habitacionRepository.saveAll(habitaciones);
        };
    }
}

