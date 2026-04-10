package com.hotel.reservation.model;

import com.hotel.reservation.enums.EstadoHabitacion;
import com.hotel.reservation.enums.TipoHabitacion;

public class Habitacion {

    private Long id;
    private String numero;
    private TipoHabitacion tipoHabitacion;
    private EstadoHabitacion estado;
    private double tarifaBase;

    public Habitacion() {
    }

    public Habitacion(Long id, String numero, TipoHabitacion tipoHabitacion, EstadoHabitacion estado, double tarifaBase) {
        this.id = id;
        this.numero = numero;
        this.tipoHabitacion = tipoHabitacion;
        this.estado = estado;
        this.tarifaBase = tarifaBase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }
}

