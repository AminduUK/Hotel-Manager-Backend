package edu.icet.Hotel.service;

import edu.icet.Hotel.dto.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> getBookings();

    void addNewBooking(Booking booking);
}
