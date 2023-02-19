package dev.felipesantana.learningspring.business;

import dev.felipesantana.learningspring.data.Room;
import dev.felipesantana.learningspring.data.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        Iterable<Room> rooms = this.roomRepository.findAll();
        List<Room> roomList = new ArrayList<>();

        rooms.forEach(roomList::add);
        roomList.sort(Comparator.comparing(Room::getRoomNumber));

        return roomList;
    }
}
