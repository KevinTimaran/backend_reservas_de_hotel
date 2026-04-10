package com.hotel.reservation.service;

import com.hotel.reservation.model.LlaveDigital;
import com.hotel.reservation.model.Reserva;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AccesoService {

    private final Map<Long, LlaveDigital> llavesPorReserva = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    public LlaveDigital generarLlaveDigital(Reserva reserva) {
        LlaveDigital llaveDigital = new LlaveDigital();
        llaveDigital.setId(sequence.getAndIncrement());
        llaveDigital.setReservaId(reserva.getId());
        llaveDigital.setCodigoAcceso(UUID.randomUUID().toString());
        llaveDigital.setFechaActivacion(LocalDateTime.now());
        llaveDigital.setFechaExpiracion(LocalDateTime.now().plusDays(2));
        llaveDigital.setActiva(true);

        // TODO: Ajustar vigencia segun check-in/check-out reales.
        llavesPorReserva.put(reserva.getId(), llaveDigital);
        return llaveDigital;
    }

    public void desactivarLlave(Long reservaId) {
        LlaveDigital llaveDigital = llavesPorReserva.get(reservaId);
        if (llaveDigital != null) {
            llaveDigital.setActiva(false);
        }
    }
}

