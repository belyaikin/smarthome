package me.polyubomu.smarthome.service;

import me.polyubomu.smarthome.repository.room.RoomsRepository;
import me.polyubomu.smarthome.room.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomsRepository repository;

    public List<Room> getAll() {
        return repository.findAll();
    }

    public Room get(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Room add(String name) {
        Room room = new Room();
        room.setName(name);

        return repository.save(room);
    }
}
