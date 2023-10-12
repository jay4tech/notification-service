package com.example.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    private Long id;
    private Long customerId;
    private Long hotelId;
    private Long roomId;
    private LocalDate startDate;
    private LocalDate endDate;
}
