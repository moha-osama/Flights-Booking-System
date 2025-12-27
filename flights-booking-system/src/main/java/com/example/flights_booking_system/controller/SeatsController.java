package com.example.flights_booking_system.controller;


import com.example.flights_booking_system.dto.SeatsDTO;
import com.example.flights_booking_system.model.SeatsStatus;
import com.example.flights_booking_system.repository.SeatsRepository;
import com.example.flights_booking_system.services.SeatsService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seats")
@RequiredArgsConstructor
public class SeatsController {

    private SeatsService seatsService;

    @GetMapping("/flight/{flightId}")
    public ResponseEntity<List<SeatsDTO>> getSeatsByFlightId(@PathVariable Long flightId) {
        List<SeatsDTO> seats = seatsService.getSeatsByFlightId(flightId);
        return ResponseEntity.ok(seats);
    }


    @GetMapping("/flight/{flightId}/filter")
    public ResponseEntity<List<SeatsDTO>> getSeatsByFlightIdAndStatus(@PathVariable Long flightId, @RequestParam SeatsStatus status) {

        List<SeatsDTO> seats = seatsService.getSeatsByFlightIdAndStatus(flightId, status);
        if (seats.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(seats);
    }


}
