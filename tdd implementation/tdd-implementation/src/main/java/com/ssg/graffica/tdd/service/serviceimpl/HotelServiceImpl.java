package com.ssg.graffica.tdd.service.serviceimpl;

import java.util.Optional;

import com.ssg.graffica.tdd.dao.HotelDao;
import com.ssg.graffica.tdd.model.Hotel;
import com.ssg.graffica.tdd.service.HotelService;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class HotelServiceImpl implements HotelService {

    private HotelDao hotelDao;

    public HotelServiceImpl(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Override
    public Optional<String> makeBooking(Hotel hotel) {
        // TODO Auto-generated method stub
//        return hotelDao.persistHotel(hotel);
        throw new UnsupportedOperationException("Unimplemented method 'makeBooking'");
    }

    @Override
    public boolean updateBooking(String bookingId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBooking'");
    }

    @Override
    public Optional<String> checkIn(String bookingid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkIn'");
    }

    @Override
    public Optional<String> checkOut(String bookingid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkOut'");
    }
    
}
