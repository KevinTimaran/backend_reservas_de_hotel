package com.hotel.reservation.model;

import java.time.LocalDateTime;

public class LlaveDigital {

    private Long id;
    private Long reservaId;
    private String codigoAcceso;
    private LocalDateTime fechaActivacion;
    private LocalDateTime fechaExpiracion;
    private boolean activa;

    public LlaveDigital() {
    }

    public LlaveDigital(Long id, Long reservaId, String codigoAcceso, LocalDateTime fechaActivacion,
                        LocalDateTime fechaExpiracion, boolean activa) {
        this.id = id;
        this.reservaId = reservaId;
        this.codigoAcceso = codigoAcceso;
        this.fechaActivacion = fechaActivacion;
        this.fechaExpiracion = fechaExpiracion;
        this.activa = activa;
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

    public String getCodigoAcceso() {
        return codigoAcceso;
    }

    public void setCodigoAcceso(String codigoAcceso) {
        this.codigoAcceso = codigoAcceso;
    }

    public LocalDateTime getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(LocalDateTime fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}

