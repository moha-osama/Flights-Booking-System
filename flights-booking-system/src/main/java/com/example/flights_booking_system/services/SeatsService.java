package com.example.flights_booking_system.services;

import com.example.flights_booking_system.dto.SeatsDTO;
import com.example.flights_booking_system.model.Seats;
import com.example.flights_booking_system.model.SeatsStatus;
import com.example.flights_booking_system.repository.SeatsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatsService {

    private final SeatsRepository seatsRepository;

    public SeatsService(SeatsRepository seatsRepository) {
        this.seatsRepository = seatsRepository;

    }

    public List<SeatsDTO> getSeatsByFlightId(Long flightId) {
        return seatsRepository.findByFlightId(flightId)
                .stream()
                .map(this::maptoDTO)
                .toList();
    }

    public List<SeatsDTO> getSeatsByFlightIdAndStatus(Long flightId, SeatsStatus status) {
        return seatsRepository.findByFlightIdAndStatus(flightId, status)
                .stream()
                .map(this::maptoDTO)
                .toList();
    }


    private SeatsDTO maptoDTO(Seats seat) {
        return SeatsDTO.builder()
                .id(seat.getId())
                .seat_code(seat.getSeat_code())
                //.flightId(seat.getFlight().getId())
                .status(seat.getStatus())
                .build();
    }
}
