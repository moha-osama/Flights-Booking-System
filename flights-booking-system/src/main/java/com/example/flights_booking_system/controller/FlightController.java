package com.example.flights_booking_system.Controller;


import com.example.flights_booking_system.dto.FlightDTO;
import com.example.flights_booking_system.services.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping("/all")
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        List<FlightDTO> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<FlightDTO>> getFlightById(@PathVariable Long id) {
        List<FlightDTO> flights = flightService.getFlightById(id);
        return ResponseEntity.ok(flights);
    }

    @GetMapping
    public ResponseEntity<List<FlightDTO>> getFlightsByOrigin(
            @RequestParam String origin) {

        List<FlightDTO> flights = flightService.getFlightsByOrigin(origin);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/destination")
    public ResponseEntity<List<FlightDTO>> getFlightsByDestination(
            @RequestParam String destination) {

        List<FlightDTO> flights = flightService.getFlightsByDestination(destination);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/date")
    public ResponseEntity<List<FlightDTO>> getFlightsByFlightDate(
            @RequestParam String flightDate) {

        List<FlightDTO> flights = flightService.getFlightsByFlightDate(flightDate);
        return ResponseEntity.ok(flights);
    }
}




