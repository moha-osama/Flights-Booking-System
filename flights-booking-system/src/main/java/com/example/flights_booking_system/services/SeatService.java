package com.example.flights_booking_system.services;

import com.example.flights_booking_system.dto.SeatsDTO;
import com.example.flights_booking_system.model.Seat;
import com.example.flights_booking_system.model.SeatsStatus;
import com.example.flights_booking_system.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<SeatsDTO> getSeatsByFlightId(Long flightId) {
        return seatRepository.findByFlightId(flightId)
                .stream()
                .map(this::maptoDTO)
                .toList();
    }

    public List<SeatsDTO> getSeatsByFlightIdAndStatus(Long flightId, SeatsStatus status) {
        return seatRepository.findByFlightIdAndStatus(flightId, status)
                .stream()
                .map(this::maptoDTO)
                .toList();
    }


    private SeatsDTO maptoDTO(Seat seat) {

        return SeatsDTO.builder()
                .id(seat.getId())
                .seat_code(seat.getSeat_code())
                //.flightId(seat.getFlight().getId())
                .status(seat.getStatus())
                .build();

    }
}
