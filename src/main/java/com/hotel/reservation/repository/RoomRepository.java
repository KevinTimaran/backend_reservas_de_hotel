package com.hotel.reservation.repository;

import com.hotel.reservation.model.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class RoomRepository {

    private final Map<Long, Room> rooms = new ConcurrentHashMap<>();

    public List<Room> findAll() {
        return new ArrayList<>(rooms.values());
    }

    public Optional<Room> findById(Long id) {
        return Optional.ofNullable(rooms.get(id));
    }

    public Room save(Room room) {
        rooms.put(room.getId(), room);
        return room;
    }

    public void saveAll(List<Room> roomList) {
        for (Room room : roomList) {
            rooms.put(room.getId(), room);
        }
    }
}


