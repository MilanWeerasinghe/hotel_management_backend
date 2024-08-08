package com.hotel.room.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO {
    private int id;
    private String roomNumber;
    private String type;
    private double price;
    private String status;
}
