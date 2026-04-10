package com.hotel.reservation.service;

import com.hotel.reservation.dto.ReservaDTO;
import com.hotel.reservation.enums.Temporada;
import org.springframework.stereotype.Service;

@Service
public class TarifaService {

    public double calcularTarifaBase(ReservaDTO reservaDTO) {
        // TODO: Implementar calculo real de tarifa segun dias, tipo de habitacion y promociones.
        return 100.0;
    }

    public double aplicarTemporada(double tarifaBase, Temporada temporada) {
        // TODO: Ajustar porcentajes reales de temporada alta/baja.
        if (temporada == Temporada.ALTA) {
            return tarifaBase * 1.2;
        }
        return tarifaBase;
    }
}

