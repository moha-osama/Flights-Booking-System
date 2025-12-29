package com.example.flights_booking_system.controller;


import com.example.flights_booking_system.dto.SeatsDTO;
import com.example.flights_booking_system.model.Flight;
import com.example.flights_booking_system.model.SeatsStatus;
import com.example.flights_booking_system.services.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @GetMapping("/{flightId}/seats")
    public ResponseEntity<List<SeatsDTO>> getSeatsByFlightId(@PathVariable Long flightId) {
        List<SeatsDTO> seats = seatService.getSeatsByFlightId(flightId);
        return ResponseEntity.ok(seats);
    }

    @GetMapping("/{flightId}/filter")
    public ResponseEntity<List<SeatsDTO>> getSeatsByFlightIdAndStatus(@PathVariable Flight flightId, @RequestParam SeatsStatus status) {

        List<SeatsDTO> seats = seatService.getSeatsByFlightIdAndStatus(flightId, status);
        if (seats.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(seats);
    }

}
