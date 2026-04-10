package com.hotel.reservation.service;

import com.hotel.reservation.model.DigitalKey;
import com.hotel.reservation.model.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AccessService {

    private final Map<Long, DigitalKey> keysByReservation = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    public DigitalKey generateDigitalKey(Reservation reservation) {
        DigitalKey digitalKey = new DigitalKey();
        digitalKey.setId(sequence.getAndIncrement());
        digitalKey.setReservationId(reservation.getId());
        digitalKey.setAccessCode(UUID.randomUUID().toString());
        digitalKey.setActivationTime(LocalDateTime.now());
        digitalKey.setExpirationTime(LocalDateTime.now().plusDays(2));
        digitalKey.setActive(true);

        // TODO: Align validity window with actual check-in/check-out times.
        keysByReservation.put(reservation.getId(), digitalKey);
        return digitalKey;
    }

    public void deactivateKey(Long reservationId) {
        DigitalKey digitalKey = keysByReservation.get(reservationId);
        if (digitalKey != null) {
            digitalKey.setActive(false);
        }
    }
}


