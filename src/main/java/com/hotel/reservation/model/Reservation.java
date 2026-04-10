package com.hotel.reservation.model;

import com.hotel.reservation.enums.ReservationStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private Long id;
    private Long roomId;
    private Long guestId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private ReservationStatus status;
    private List<AdditionalService> services;

    public Reservation() {
        this.services = new ArrayList<>();
    }

    public Reservation(Long id, Long roomId, Long guestId, LocalDate checkInDate,
                       LocalDate checkOutDate, ReservationStatus status, List<AdditionalService> services) {
        this.id = id;
        this.roomId = roomId;
        this.guestId = guestId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
        this.services = services == null ? new ArrayList<>() : services;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public List<AdditionalService> getServices() {
        return services;
    }

    public void setServices(List<AdditionalService> services) {
        this.services = services;
    }
}


