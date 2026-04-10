package com.hotel.reservation.facade;

import com.hotel.reservation.dto.ReservationRequestDTO;
import com.hotel.reservation.dto.ReservationResponseDTO;
import com.hotel.reservation.enums.RoomStatus;
import com.hotel.reservation.enums.ReservationStatus;
import com.hotel.reservation.exception.BadRequestException;
import com.hotel.reservation.model.Room;
import com.hotel.reservation.model.Reservation;
import com.hotel.reservation.model.AdditionalService;
import com.hotel.reservation.repository.ReservationRepository;
import com.hotel.reservation.service.AccessService;
import com.hotel.reservation.service.BillingService;
import com.hotel.reservation.service.RoomService;
import com.hotel.reservation.service.AdditionalServiceService;
import com.hotel.reservation.service.RateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelFacade {

    private final RoomService roomService;
    private final RateService rateService;
    private final AdditionalServiceService additionalServiceService;
    private final BillingService billingService;
    private final AccessService accessService;
    private final ReservationRepository reservationRepository;

    public HotelFacade(RoomService roomService, RateService rateService,
                       AdditionalServiceService additionalServiceService, BillingService billingService,
                       AccessService accessService, ReservationRepository reservationRepository) {
        this.roomService = roomService;
        this.rateService = rateService;
        this.additionalServiceService = additionalServiceService;
        this.billingService = billingService;
        this.accessService = accessService;
        this.reservationRepository = reservationRepository;
    }

    public List<Room> listRooms() {
        return roomService.getAll();
    }

    public ReservationResponseDTO createReservation(ReservationRequestDTO reservationRequestDTO) {
        Room room = roomService.getById(reservationRequestDTO.getRoomId());
        if (room.getStatus() != RoomStatus.AVAILABLE) {
            throw new BadRequestException("The room is not available for reservation.");
        }

        List<AdditionalService> services = additionalServiceService.createServices(reservationRequestDTO.getServices());

        Reservation reservation = new Reservation();
        reservation.setRoomId(reservationRequestDTO.getRoomId());
        reservation.setGuestId(reservationRequestDTO.getGuestId());
        reservation.setCheckInDate(reservationRequestDTO.getCheckInDate());
        reservation.setCheckOutDate(reservationRequestDTO.getCheckOutDate());
        reservation.setStatus(ReservationStatus.CREATED);
        reservation.setServices(services);

        // TODO: Validate availability by date range and cancellation policies.
        Reservation savedReservation = reservationRepository.save(reservation);

        roomService.updateStatus(room.getId(), RoomStatus.RESERVED);

        double baseRate = rateService.calculateBaseRate(reservationRequestDTO);
        double servicesCost = additionalServiceService.calculateTotalCost(services);
        double subtotal = baseRate + servicesCost;

        billingService.generateInvoice(savedReservation, subtotal);
        accessService.generateDigitalKey(savedReservation);

        return new ReservationResponseDTO(
                savedReservation.getId(),
                savedReservation.getStatus(),
                subtotal,
                "Reservation created successfully"
        );
    }
}

