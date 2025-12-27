package com.example.flights_booking_system.repository;

import com.example.flights_booking_system.model.SeatsStatus;
import com.example.flights_booking_system.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, Long> {

    List<Seats> findByFlightId(Long flightId);
    List<Seats> findByFlightIdAndStatus(Long flightId, SeatsStatus seatStatus);

}
