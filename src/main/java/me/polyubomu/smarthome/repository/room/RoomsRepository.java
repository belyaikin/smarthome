package me.polyubomu.smarthome.repository.room;

import me.polyubomu.smarthome.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<Room, Long> {
}
