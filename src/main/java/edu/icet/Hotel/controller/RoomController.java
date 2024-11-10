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

    @GetMapping("/getAll")
    public List<Room> getAllRooms() {
        return roomService.getRooms();
    }


    @PutMapping("/changeAvailability")
    public ResponseEntity<String> changeRoomAvailability(@RequestBody Map<String, Object> request) {
        Long roomId = request.get("roomId") != null ? Long.valueOf(request.get("roomId").toString()) : null;
        String availability = (String) request.get("availability");

        if (roomId == null || availability == null) {
            return ResponseEntity.badRequest().body("Room ID and availability are required.");
        }

        boolean updated = roomService.updateRoomAvailability(roomId, availability);

        if (updated) {
            return ResponseEntity.ok("Room availability updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room not found or update failed.");
        }
    }

    @GetMapping("/getAvailableRooms")
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }


}
