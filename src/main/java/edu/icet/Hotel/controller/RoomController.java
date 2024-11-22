package edu.icet.Hotel.controller;

import edu.icet.Hotel.dto.Room;
import edu.icet.Hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {

    final RoomService roomService;

    @PostMapping("/addNew-room")
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

    public void restoredRoomAvailability(Long roomID) {
        roomService.updateRoomAvailability(roomID, "Available");
    }

    @GetMapping("/getAll-rooms")
    public List<Room> getAllRooms() {
        return roomService.getRooms();
    }

    @GetMapping("/get-available-rooms")
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

}
