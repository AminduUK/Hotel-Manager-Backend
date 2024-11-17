package edu.icet.Hotel.controller;

import edu.icet.Hotel.dto.Room;
import edu.icet.Hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {

    final RoomService roomService;

    @PostMapping("/addNewRoom")
    public boolean addNewRoom(@RequestBody Room room) {
        if (room != null) {
            roomService.addNewRoom(room);
            return true;
        } else {
            return false;
        }
    }

    public void changeRoomAvailability(Long roomID) {
        roomService.updateRoomAvailability(roomID, "Occupied");
    }

    @GetMapping("/getAllRooms")
    public List<Room> getAllRooms() {
        return roomService.getRooms();
    }



    @GetMapping("/getAvailableRooms")
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }


}
