package edu.icet.Hotel.service;

import edu.icet.Hotel.dto.Room;

import java.util.List;

public interface RoomService {

    void addNewRoom(Room room);

    List<Room> getRooms();

    void updateRoomAvailability(Long roomId, String availability);

    List<Room> getAvailableRooms();
}
