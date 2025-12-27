package com.example.flights_booking_system.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Seats")

public class Seats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //@ManyToOne
    //@JoinColumn(name = "flight_id", nullable = false)
    //private Flights flight;

    private String seat_code;

    private Boolean status;

    private int version;

}
