package com.example.flights_booking_system.Repository;

import com.example.flights_booking_system.model.Flight;
import com.example.flights_booking_system.model.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    // Search by Status
    @RestResource(path = "findByStatus" ,rel = "findByStatus")
    List<Flight> findByStatus(@Param("status") FlightStatus status);

    // Search by date
    @RestResource(path = "findByFlightDate" ,rel = "findByFlightDate")
    List<Flight> findByFlightDate(@Param("flight_date") String flightDate);

    // Search by origin
    @RestResource(path = "findByOriginAirport" ,rel = "findByOriginAirport")
    List<Flight> findByOriginAirport(@Param("origin_airport") String originAirport);

    // Search by destination
    @RestResource(path = "findByDestinationAirport" ,rel = "findByDestinationAirport")
    List<Flight> findByDestinationAirport(@Param("destination_airport") String destinationAirport);
}
