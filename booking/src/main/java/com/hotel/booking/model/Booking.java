package com.hotel.booking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
    @Id
    private int id;
    private int userId;
    private int roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}
