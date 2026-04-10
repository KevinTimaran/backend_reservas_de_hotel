package com.hotel.reservation.model;

import java.time.LocalDateTime;

public class Invoice {

    private Long id;
    private Long reservationId;
    private double subtotal;
    private double taxes;
    private double total;
    private LocalDateTime issuedAt;

    public Invoice() {
    }

    public Invoice(Long id, Long reservationId, double subtotal, double taxes, double total, LocalDateTime issuedAt) {
        this.id = id;
        this.reservationId = reservationId;
        this.subtotal = subtotal;
        this.taxes = taxes;
        this.total = total;
        this.issuedAt = issuedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }
}


