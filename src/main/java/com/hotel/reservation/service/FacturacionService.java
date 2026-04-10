package com.hotel.reservation.service;

import com.hotel.reservation.exception.ResourceNotFoundException;
import com.hotel.reservation.model.Factura;
import com.hotel.reservation.model.Reserva;
import com.hotel.reservation.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FacturacionService {

    private final FacturaRepository facturaRepository;

    public FacturacionService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public Factura generarFactura(Reserva reserva, double subtotal) {
        // TODO: Aplicar reglas tributarias reales por pais y moneda.
        double impuestos = subtotal * 0.19;
        double total = subtotal + impuestos;

        Factura factura = new Factura();
        factura.setReservaId(reserva.getId());
        factura.setSubtotal(subtotal);
        factura.setImpuestos(impuestos);
        factura.setTotal(total);
        factura.setFechaEmision(LocalDateTime.now());

        return facturaRepository.save(factura);
    }

    public Factura obtenerPorReservaId(Long reservaId) {
        return facturaRepository.findByReservaId(reservaId)
                .orElseThrow(() -> new ResourceNotFoundException("Factura no encontrada para reserva: " + reservaId));
    }
}

