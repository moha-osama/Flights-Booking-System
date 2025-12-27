package com.example.flights_booking_system.Service;

import com.example.flights_booking_system.Repository.FlightRepository;
import com.example.flights_booking_system.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    private FlightRepository flightRepository;


    @Autowired
    public FlightServiceImpl(FlightRepository theFlightRepository) {
        flightRepository = theFlightRepository;
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight findById(long theId) {
        Optional<Flight> flight = flightRepository.findById((int) theId);
        Flight theFlight = null;

        if(flight.isPresent()){
            theFlight = flight.get();
        } else {
            throw new RuntimeException("Did not find flight id - " + theId);
        }
        return theFlight;
    }

    @Override
    public Flight save(Flight theFlight) {
        return flightRepository.save(theFlight);
    }

    @Override
    public void deleteById(int theId) {
        flightRepository.deleteById(theId);
    }
}
