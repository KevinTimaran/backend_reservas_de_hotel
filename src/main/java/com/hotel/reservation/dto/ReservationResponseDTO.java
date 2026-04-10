package com.hotel.reservation.dto;

import com.hotel.reservation.enums.ReservationStatus;

public class ReservationResponseDTO {

    private Long reservationId;
    private ReservationStatus status;
    private double estimatedTotal;
    private String message;

    public ReservationResponseDTO() {
    }

    public ReservationResponseDTO(Long reservationId, ReservationStatus status, double estimatedTotal, String message) {
        this.reservationId = reservationId;
        this.status = status;
        this.estimatedTotal = estimatedTotal;
        this.message = message;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public double getEstimatedTotal() {
        return estimatedTotal;
    }

    public void setEstimatedTotal(double estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


