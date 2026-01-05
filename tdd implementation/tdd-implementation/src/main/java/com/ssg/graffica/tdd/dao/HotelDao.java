package com.ssg.graffica.tdd.dao;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import com.ssg.graffica.tdd.model.Hotel;

import lombok.Builder;

@Builder
public class HotelDao {
    
    public Optional<String> persistHotel(Hotel hotel) {
        if (hotel != null) {
            Hotel toPersist = new Hotel(hotel.getHotelId(), UUID.randomUUID().toString(),
            hotel.getHotelName(),  hotel.getHotelName(), hotel.getRoomNum(), LocalDateTime.now(), null);
            return Optional.of(toPersist.getBookingId());
        }
        return Optional.empty();
        //return null;
    }
    
}
