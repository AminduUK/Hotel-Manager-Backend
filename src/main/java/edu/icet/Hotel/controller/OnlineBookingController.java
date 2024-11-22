package edu.icet.Hotel.controller;

import edu.icet.Hotel.dto.Booking;
import edu.icet.Hotel.dto.OnlineBooking;
import edu.icet.Hotel.service.OnlineBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/online-booking")
public class OnlineBookingController {

    final OnlineBookingService onlineBookingService;
    final RoomController roomController;

    @GetMapping("/getAll-online-bookings")
    public List<OnlineBooking> getAllOnlineBookings() {
        return onlineBookingService.getOnlineBookings();
    }

    @PostMapping("/addNew-online-booking")
    public boolean addNewOnlineBooking(@RequestBody OnlineBooking onlineBooking ) {
        if (onlineBooking != null) {
            onlineBookingService.addNewOnlineBooking(onlineBooking);
            roomController.changeRoomAvailability(onlineBooking.getRoomIdOnl());
            return true;
        } else {
            return false;
        }
    }
}
