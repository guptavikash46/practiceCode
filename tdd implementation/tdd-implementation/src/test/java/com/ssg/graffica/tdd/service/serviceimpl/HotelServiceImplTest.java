package com.ssg.graffica.tdd.service.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ssg.graffica.tdd.dao.HotelDao;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
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
public class HotelServiceImplTest {
    
    private static final String DUMMY_BOOK_ID = "testBookId";
    @Mock
    private HotelServiceImpl systemUnderTest; //replica
    @Mock
    private HotelDao hotelDao;
    
    private Hotel hotel;
    

    @BeforeEach
    void setUp() {
        hotel = new Hotel(1, "testBookId", "test hotel", "G1", 301, LocalDateTime.now(), null);
        System.out.println("Executes before each test. --> "+ hotel);
    }

    /**
     * Verify that the booking is made successfully.
     */
    @Test
    void makeBookingTest() {
        //arrange
        
        when(systemUnderTest.makeBooking(hotel)).thenReturn(Optional.of(DUMMY_BOOK_ID));
        
        //act
        String bookingId = systemUnderTest.makeBooking(hotel).get();
        String bookIdFromDao = hotelDao.persistHotel(hotel).get();
        //assert
        assertEquals();
        assertEquals(hotel.getBookingId(), bookingId);
        verify(hotelDao).persistHotel(hotel);
        verify(systemUnderTest).makeBooking(hotel);
    }
    @Test
    void updateBookingTest() {
        //arrange
        when(systemUnderTest.updateBooking(DUMMY_BOOK_ID)).thenReturn(Boolean.valueOf(true));
        //act
        boolean bookingStatus = systemUnderTest.updateBooking(DUMMY_BOOK_ID);
        //assert
        verify(systemUnderTest).updateBooking(DUMMY_BOOK_ID);
        assertTrue(bookingStatus);
    }
    @Test
    void checkInTest() {
        //arrange
        when(systemUnderTest.checkIn(DUMMY_BOOK_ID)).thenReturn(Optional.of(DUMMY_BOOK_ID));
        //act
        String bookingId = systemUnderTest.checkIn(DUMMY_BOOK_ID).get();
        //assert
        assertEquals(hotel.getBookingId(), bookingId);
        
    }
    
}
