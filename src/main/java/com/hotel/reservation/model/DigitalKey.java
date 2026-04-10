package com.hotel.reservation.model;

import java.time.LocalDateTime;

public class DigitalKey {

    private Long id;
    private Long reservationId;
    private String accessCode;
    private LocalDateTime activationTime;
    private LocalDateTime expirationTime;
    private boolean active;

    public DigitalKey() {
    }

    public DigitalKey(Long id, Long reservationId, String accessCode, LocalDateTime activationTime,
                      LocalDateTime expirationTime, boolean active) {
        this.id = id;
        this.reservationId = reservationId;
        this.accessCode = accessCode;
        this.activationTime = activationTime;
        this.expirationTime = expirationTime;
        this.active = active;
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

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public LocalDateTime getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(LocalDateTime activationTime) {
        this.activationTime = activationTime;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}


