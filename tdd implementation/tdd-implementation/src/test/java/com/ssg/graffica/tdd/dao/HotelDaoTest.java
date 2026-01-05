package com.ssg.graffica.tdd.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.ssg.graffica.tdd.model.Hotel;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class HotelDaoTest {

    @Mock
    private HotelDao hotelDao;
    @InjectMocks
    private Hotel hotel;
    

    @Test
    void persistHotelWhenNotNullTest() {
        //arrange
        when(hotelDao.persistHotel(hotel)).thenReturn(Optional.of("test booking id"));
        //act
        String bookingId = hotelDao.persistHotel(hotel).get();
        //assert
        assertEquals("test booking id", bookingId);



    }
}
