package com.hotel.reservation.config;

import com.hotel.reservation.enums.RoomStatus;
import com.hotel.reservation.enums.RoomType;
import com.hotel.reservation.model.Room;
import com.hotel.reservation.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner preloadRooms(RoomRepository roomRepository) {
        return args -> {
            if (!roomRepository.findAll().isEmpty()) {
                return;
            }

            List<Room> rooms = new ArrayList<>();
            for (int i = 1; i <= 15; i++) {
                RoomType roomType;
                if (i <= 5) {
                    roomType = RoomType.SINGLE;
                } else if (i <= 10) {
                    roomType = RoomType.DOUBLE;
                } else {
                    roomType = RoomType.SUITE;
                }

                Room room = new Room(
                        (long) i,
                        String.valueOf(100 + i),
                        roomType,
                        RoomStatus.AVAILABLE,
                        100.0 + (i * 10)
                );
                rooms.add(room);
            }

            // TODO: Externalize data seed when real persistence layer exists.
            roomRepository.saveAll(rooms);
        };
    }
}

