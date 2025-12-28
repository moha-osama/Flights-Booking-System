package com.example.flights_booking_system.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "Flight")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private String  flightDate;
    private String origin;
    private String destination;
    private String scheduledDepartureTime;
    private String actualDepartureTime;
    private String status;
    private Double price;
}
