package me.polyubomu.smarthome.shell;

import me.polyubomu.smarthome.room.entity.Room;
import me.polyubomu.smarthome.service.DeviceService;
import me.polyubomu.smarthome.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class SmarthomeCommands {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private RoomService roomService;

    @ShellMethod(key = "rooms")
    public String allRooms() {
        System.out.println("All rooms:\n");

        StringBuilder rooms = new StringBuilder();

        for (Room room : roomService.getAll()) {
            rooms
                    .append(room.getId())
                    .append(": ")
                    .append(room.getName())
                    .append("\n");
        }

        return rooms.toString();
    }

    @ShellMethod(key = "add-room")
    public String addRoom(@ShellOption String name) {
        roomService.add(name);

        return "Created new room with name " + name;
    }
}
