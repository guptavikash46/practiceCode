package com.ssg.graffica.tdd.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class Hotel {

    private int hotelId;
    private String bookingId;
    private String HotelName;
    private String guestName;
    private int roomNum;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    
    public Hotel() {}
    
    public Hotel(int hotelId, String bookingId, String hotelName, String guestName, int roomNum,
          LocalDateTime checkIn, LocalDateTime checkOut) {
        this.hotelId = hotelId;
        this.bookingId = bookingId;
        HotelName = hotelName;
        this.guestName = guestName;
        this.roomNum = roomNum;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    
    public int getHotelId() {
        return hotelId;
    }
    
    public String getBookingId() {
        return bookingId;
    }
    
    public String getHotelName() {
        return HotelName;
    }
    
    public String getGuestName() {
        return guestName;
    }
    
    public int getRoomNum() {
        return roomNum;
    }
    
    public LocalDateTime getCheckIn() {
        return checkIn;
    }
    
    public LocalDateTime getCheckOut() {
        return checkOut;
    }
    
    @Override
    public String toString() {
        return "Hotel{" +
              "hotelId=" + hotelId +
              ", bookingId='" + bookingId + '\'' +
              ", HotelName='" + HotelName + '\'' +
              ", guestName='" + guestName + '\'' +
              ", roomNum=" + roomNum +
              ", checkIn=" + checkIn +
              ", checkOut=" + checkOut +
              '}';
    }
}
