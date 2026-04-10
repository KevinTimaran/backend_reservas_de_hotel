package com.hotel.reservation.model;

import com.hotel.reservation.enums.TipoServicio;

public class ServicioAdicional {

    private Long id;
    private TipoServicio tipoServicio;
    private String descripcion;
    private double costo;

    public ServicioAdicional() {
    }

    public ServicioAdicional(Long id, TipoServicio tipoServicio, String descripcion, double costo) {
        this.id = id;
        this.tipoServicio = tipoServicio;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}

