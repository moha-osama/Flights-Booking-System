package com.example.flights_booking_system.services;

import com.example.flights_booking_system.dto.SeatsDTO;
import com.example.flights_booking_system.model.Flight;
import com.example.flights_booking_system.model.Seat;
import com.example.flights_booking_system.model.SeatsStatus;
import com.example.flights_booking_system.repository.FlightRepository;
import com.example.flights_booking_system.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;
    private final FlightRepository flightRepository;

    public SeatService(SeatRepository seatRepository, FlightRepository flightRepository) {
        this.seatRepository = seatRepository;
        this.flightRepository = flightRepository;
    }

    public List<SeatsDTO> getSeatsByFlightId(Long flightId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        return seatRepository.findByFlightId(flight)
                .stream()
                .map(seat -> SeatsDTO.builder()
                        .id(seat.getId())
                        .seat_code(seat.getSeat_code())
                        .status(seat.getStatus())
                        .build())
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
