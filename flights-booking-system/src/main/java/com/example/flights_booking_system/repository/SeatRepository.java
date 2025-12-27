package com.example.flights_booking_system.repository;

import com.example.flights_booking_system.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seats, Long> {
}
