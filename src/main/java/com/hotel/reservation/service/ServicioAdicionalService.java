package com.hotel.reservation.service;

import com.hotel.reservation.dto.ServicioDTO;
import com.hotel.reservation.model.ServicioAdicional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioAdicionalService {

    public List<ServicioAdicional> crearServicios(List<ServicioDTO> serviciosDTO) {
        List<ServicioAdicional> servicios = new ArrayList<>();
        if (serviciosDTO == null) {
            return servicios;
        }

        for (ServicioDTO dto : serviciosDTO) {
            servicios.add(new ServicioAdicional(dto.getId(), dto.getTipoServicio(), dto.getDescripcion(), dto.getCosto()));
        }

        // TODO: Enriquecer conversion con reglas y catalogo de servicios.
        return servicios;
    }

    public double calcularCostoTotal(List<ServicioAdicional> servicios) {
        if (servicios == null || servicios.isEmpty()) {
            return 0.0;
        }
        return servicios.stream().mapToDouble(ServicioAdicional::getCosto).sum();
    }
}

