package com.hotel.reservation.service;

import com.hotel.reservation.enums.RoomStatus;
import com.hotel.reservation.exception.ResourceNotFoundException;
import com.hotel.reservation.model.Room;
import com.hotel.reservation.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public Room getById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + id));
    }

    public Room save(Room room) {
        // TODO: Add business validations before saving.
        return roomRepository.save(room);
    }

    public Room updateStatus(Long id, RoomStatus status) {
        Room room = getById(id);
        // TODO: Validate allowed state transitions.
        room.setStatus(status);
        return roomRepository.save(room);
    }
}


