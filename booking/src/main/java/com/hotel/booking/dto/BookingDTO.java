package com.hotel.booking.dto;

import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private int id;
    private int userId;
    private int roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}
