package com.example.flights_booking_system.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {

    private Long id;
    @NotNull(message = "Flight Number is required")
    private String flightNumber;
    @NotNull(message = "Flight Date is required")
    private String flightDate;
    private String origin;
    private String destination;
    private String scheduledDepartureTime;
    private String actualDepartureTime;
    private String status;
}
