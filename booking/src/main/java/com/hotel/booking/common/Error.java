package com.hotel.booking.common;

import lombok.Getter;

@Getter
public class Error implements BookingResponse{
    private final String error;

    public Error(String error){
        this.error = error;
    }
}
