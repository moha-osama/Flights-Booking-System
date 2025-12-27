package com.example.flights_booking_system.Service;

import com.example.flights_booking_system.model.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> findAll();
    Flight findById(long theId);
    Flight save(Flight theFlight);
    void deleteById(int theId);
}
