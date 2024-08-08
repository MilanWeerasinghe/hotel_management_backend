package com.hotel.booking.common;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.hotel.booking.dto.BookingDTO;
import com.hotel.room.dto.RoomDTO;
import lombok.Getter;

@Getter
public class Success implements BookingResponse{
    @JsonUnwrapped
    private final BookingDTO booking;

    public Success(BookingDTO booking){
        this.booking = booking;
    }
}
