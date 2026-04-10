package com.hotel.reservation.service;

import com.hotel.reservation.dto.ReservationRequestDTO;
import com.hotel.reservation.enums.Season;
import org.springframework.stereotype.Service;

@Service
public class RateService {

    public double calculateBaseRate(ReservationRequestDTO reservationRequestDTO) {
        // TODO: Implement actual rate calculation based on days, room type and promotions.
        return 100.0;
    }

    public double applySeason(double baseRate, Season season) {
        // TODO: Adjust real percentages for high/low season.
        if (season == Season.HIGH) {
            return baseRate * 1.2;
        }
        return baseRate;
    }
}


