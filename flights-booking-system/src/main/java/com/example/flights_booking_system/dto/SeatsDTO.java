package com.example.flights_booking_system.dto;

import com.example.flights_booking_system.model.SeatsStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatsDTO {

    private Long id;

    @NotNull(message = "Flight ID is required")
     private Long flightId;

    @NotBlank(message = "Seat code is required")
    private String seat_code;

    private SeatsStatus status;


}
