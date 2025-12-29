package com.example.flights_booking_system.services;


import com.example.flights_booking_system.dto.FlightDTO;
import com.example.flights_booking_system.model.Flight;
import com.example.flights_booking_system.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    public List<FlightDTO> getAllFlights() {
        return flightRepository.findAll()
                .stream()
                .map(this::maptoDTO)
                .toList();
    }

    public List<FlightDTO> getFlightById(Long id) {
        return flightRepository.getFlightById(id)
                .stream()
                .map(this::maptoDTO)
                .toList();
    }

    public List<FlightDTO> getFlightsByOrigin(String origin) {
        return flightRepository.findByOrigin(origin)
                .stream()
                .map(this::maptoDTO)
                .toList();
    }

    public List<FlightDTO> getFlightsByDestination(String destination) {
        return flightRepository.findByDestination(destination)
                .stream()
                .map(this::maptoDTO)
                .toList();
    }

    public List<FlightDTO> getFlightsByFlightDate(String flightDate) {
        return flightRepository.findByFlightDate(flightDate)
                .stream()
                .map(this::maptoDTO)
                .toList();
    }


    private FlightDTO maptoDTO(Flight flight) {

        return FlightDTO.builder()
                .id(flight.getId())
                .origin(flight.getOrigin())
                .destination(flight.getDestination())
                .flightDate(flight.getFlightDate())
                .scheduledDepartureTime(flight.getScheduledDepartureTime())
                .actualDepartureTime(flight.getActualDepartureTime())
                .status(flight.getStatus())
                .build();


    }
}
