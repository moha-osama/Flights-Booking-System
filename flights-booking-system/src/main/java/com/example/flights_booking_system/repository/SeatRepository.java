package com.example.flights_booking_system.repository;

import com.example.flights_booking_system.model.SeatsStatus;
import com.example.flights_booking_system.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findByFlightId(Long flightId);
    List<Seat> findByFlightIdAndStatus(Long flightId, SeatsStatus seatStatus);

}
