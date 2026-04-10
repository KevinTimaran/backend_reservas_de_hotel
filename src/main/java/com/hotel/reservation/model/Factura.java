package com.hotel.reservation.model;

import java.time.LocalDateTime;

public class Factura {

    private Long id;
    private Long reservaId;
    private double subtotal;
    private double impuestos;
    private double total;
    private LocalDateTime fechaEmision;

    public Factura() {
    }

    public Factura(Long id, Long reservaId, double subtotal, double impuestos, double total, LocalDateTime fechaEmision) {
        this.id = id;
        this.reservaId = reservaId;
        this.subtotal = subtotal;
        this.impuestos = impuestos;
        this.total = total;
        this.fechaEmision = fechaEmision;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
}

