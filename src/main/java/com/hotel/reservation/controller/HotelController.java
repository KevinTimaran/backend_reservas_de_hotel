package com.hotel.reservation.controller;

import com.hotel.reservation.dto.ReservaDTO;
import com.hotel.reservation.dto.ReservaResponseDTO;
import com.hotel.reservation.facade.HotelFacade;
import com.hotel.reservation.model.Habitacion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    private final HotelFacade hotelFacade;

    public HotelController(HotelFacade hotelFacade) {
        this.hotelFacade = hotelFacade;
    }

    @GetMapping("/habitaciones")
    public ResponseEntity<List<Habitacion>> listarHabitaciones() {
        return ResponseEntity.ok(hotelFacade.listarHabitaciones());
    }

    @PostMapping("/reservas")
    public ResponseEntity<ReservaResponseDTO> crearReserva(@RequestBody ReservaDTO reservaDTO) {
        ReservaResponseDTO response = hotelFacade.crearReserva(reservaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

