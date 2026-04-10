package com.hotel.reservation.model;

import com.hotel.reservation.enums.RoomStatus;
import com.hotel.reservation.enums.RoomType;

public class Room {

    private Long id;
    private String number;
    private RoomType roomType;
    private RoomStatus status;
    private double baseRate;

    public Room() {
    }

    public Room(Long id, String number, RoomType roomType, RoomStatus status, double baseRate) {
        this.id = id;
        this.number = number;
        this.roomType = roomType;
        this.status = status;
        this.baseRate = baseRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }
}


