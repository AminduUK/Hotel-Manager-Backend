package edu.icet.Hotel.service;

import edu.icet.Hotel.dto.Booking;
import edu.icet.Hotel.dto.OnlineBooking;

import java.util.List;

public interface OnlineBookingService {

    List<OnlineBooking> getOnlineBookings();

    void addNewOnlineBooking(OnlineBooking onlineBooking);
}
