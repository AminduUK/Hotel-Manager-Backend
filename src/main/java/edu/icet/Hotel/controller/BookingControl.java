package edu.icet.Hotel.controller;

import edu.icet.Hotel.dto.Booking;
import edu.icet.Hotel.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingControl {

    final BookingService bookingService;
    final RoomController roomController;

    @GetMapping("/getAllBookings")
    public List<Booking> getAllBookings() {
        return bookingService.getBookings();
    }

    @PostMapping("/addNewBooking")
    public boolean addNewBooking(@RequestBody Booking booking ) {
        if (booking != null) {
            bookingService.addNewBooking(booking);
            roomController.changeRoomAvailability(booking.getRoomId());
            return true;
        } else {
            return false;
        }
    }

}
