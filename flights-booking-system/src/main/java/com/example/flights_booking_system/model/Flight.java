package com.example.flights_booking_system.model;

import jakarta.persistence.*;

@Entity
@Table(name="flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="flight_number")
    private String flightNumber;

    @Column(name="flight_date")
    private String flightDate;

    @Column(name="origin_airport")
    private String originAirport;

    @Column(name="destination_airport")
    private String destinationAirport;

    @Column(name="scheduled_departure_time")
    private String scheduledDepartureTime;

    @Column(name="actual_departure_time")
    private String actualDepartureTime;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    public Flight(){
    }

    public Flight(String flightNumber, String flightDate, String originAirport, String destinationAirport, String scheduledDepartureTime, String actualDepartureTime, FlightStatus status) {
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.scheduledDepartureTime = scheduledDepartureTime;
        this.actualDepartureTime = actualDepartureTime;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getScheduledDepartureTime() {
        return scheduledDepartureTime;
    }

    public void setScheduledDepartureTime(String scheduledDepartureTime) {
        this.scheduledDepartureTime = scheduledDepartureTime;
    }

    public String getActualDepartureTime() {
        return actualDepartureTime;
    }

    public void setActualDepartureTime(String actualDepartureTime) {
        this.actualDepartureTime = actualDepartureTime;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", flightDate='" + flightDate + '\'' +
                ", originAirport='" + originAirport + '\'' +
                ", destinationAirport='" + destinationAirport + '\'' +
                ", scheduledDepartureTime='" + scheduledDepartureTime + '\'' +
                ", actualDepartureTime='" + actualDepartureTime + '\'' +
                ", status=" + status +
                '}';
    }
}
