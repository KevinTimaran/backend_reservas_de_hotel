package com.hotel.reservation.controller;

import com.hotel.reservation.dto.ReservationRequestDTO;
import com.hotel.reservation.dto.ReservationResponseDTO;
import com.hotel.reservation.facade.HotelFacade;
import com.hotel.reservation.model.Room;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelFacade hotelFacade;

    public HotelController(HotelFacade hotelFacade) {
        this.hotelFacade = hotelFacade;
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> listRooms() {
        return ResponseEntity.ok(hotelFacade.listRooms());
    }

    @PostMapping("/reservations")
    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        ReservationResponseDTO response = hotelFacade.createReservation(reservationRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

