package com.hotel.reservation.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationRequestDTO {

    private Long roomId;
    private Long guestId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private List<ServiceRequestDTO> services;

    public ReservationRequestDTO() {
        this.services = new ArrayList<>();
    }

    public ReservationRequestDTO(Long roomId, Long guestId, LocalDate checkInDate, LocalDate checkOutDate,
                                 List<ServiceRequestDTO> services) {
        this.roomId = roomId;
        this.guestId = guestId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.services = services == null ? new ArrayList<>() : services;
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

    public List<ServiceRequestDTO> getServices() {
        return services;
    }

    public void setServices(List<ServiceRequestDTO> services) {
        this.services = services;
    }
}


