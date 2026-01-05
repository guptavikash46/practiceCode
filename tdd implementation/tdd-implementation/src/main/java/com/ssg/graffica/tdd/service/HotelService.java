package com.ssg.graffica.tdd.service;

import java.util.Optional;

import com.ssg.graffica.tdd.model.Hotel;

public interface HotelService {

    Optional<String> makeBooking(Hotel hotel);

    boolean updateBooking(String bookingId);

    Optional<String> checkIn(String bookingid);
    
    Optional<String> checkOut(String bookingid);

    
    
}
