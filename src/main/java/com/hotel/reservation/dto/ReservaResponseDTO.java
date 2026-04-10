package com.hotel.reservation.dto;

import com.hotel.reservation.enums.EstadoReserva;

public class ReservaResponseDTO {

    private Long reservaId;
    private EstadoReserva estado;
    private double totalEstimado;
    private String mensaje;

    public ReservaResponseDTO() {
    }

    public ReservaResponseDTO(Long reservaId, EstadoReserva estado, double totalEstimado, String mensaje) {
        this.reservaId = reservaId;
        this.estado = estado;
        this.totalEstimado = totalEstimado;
        this.mensaje = mensaje;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public double getTotalEstimado() {
        return totalEstimado;
    }

    public void setTotalEstimado(double totalEstimado) {
        this.totalEstimado = totalEstimado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

