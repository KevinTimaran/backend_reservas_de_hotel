package com.hotel.reservation.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaDTO {

    private Long habitacionId;
    private Long huespedId;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private List<ServicioDTO> servicios;

    public ReservaDTO() {
        this.servicios = new ArrayList<>();
    }

    public ReservaDTO(Long habitacionId, Long huespedId, LocalDate fechaEntrada, LocalDate fechaSalida,
                      List<ServicioDTO> servicios) {
        this.habitacionId = habitacionId;
        this.huespedId = huespedId;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.servicios = servicios == null ? new ArrayList<>() : servicios;
    }

    public Long getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(Long habitacionId) {
        this.habitacionId = habitacionId;
    }

    public Long getHuespedId() {
        return huespedId;
    }

    public void setHuespedId(Long huespedId) {
        this.huespedId = huespedId;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public List<ServicioDTO> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioDTO> servicios) {
        this.servicios = servicios;
    }
}

