package com.example.flights_booking_system.repository;


import com.example.flights_booking_system.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> getFlightById(Long id);
    List<Flight> findByOrigin(String origin);
    List<Flight> findByDestination(String destination);
    List<Flight> findByFlightDate(String flightDate);
}
