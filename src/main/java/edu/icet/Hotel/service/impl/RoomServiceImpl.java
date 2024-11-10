package edu.icet.Hotel.service.impl;

import edu.icet.Hotel.dto.Room;
import edu.icet.Hotel.entity.RoomEntity;
import edu.icet.Hotel.repository.RoomDao;
import edu.icet.Hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    final RoomDao roomDao;
    final ModelMapper modelMapper;

    @Override
    public void addNewRoom(Room room) {
        RoomEntity roomEntity = modelMapper.map(room, RoomEntity.class);
        roomDao.save(roomEntity);
    }

    @Override
    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<>();
        roomDao.findAll().forEach(RoomEntity->{
            rooms.add(modelMapper.map(RoomEntity, Room.class));
        });
        return rooms;
    }

    @Override
    public boolean updateRoomAvailability(Long roomId, String availability) {
        // Check if the room with the specified ID exists
        Optional<RoomEntity> optionalRoom = roomDao.findById(roomId);

        if (optionalRoom.isPresent()) {
            RoomEntity room = optionalRoom.get();
            // Update the availability field
            room.setAvailability(availability);
            roomDao.save(room);
            return true;
        } else {
            return false; // Room not found
        }
    }

    @Override
    public List<Room> getAvailableRooms() {
        List<RoomEntity> availableRooms = roomDao.findByAvailability("available");
        List<Room> roomDtoList = new ArrayList<>();

        availableRooms.forEach(roomEntity -> {
            Room roomDto = modelMapper.map(roomEntity, Room.class);
            roomDtoList.add(roomDto);
        });

        return roomDtoList;
    }
}
