package com.example.flights_booking_system.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flightId;

    private String seat_code;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatsStatus status;

    private int version;

}
