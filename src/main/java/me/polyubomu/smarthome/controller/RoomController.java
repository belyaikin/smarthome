package me.polyubomu.smarthome.controller;

import me.polyubomu.smarthome.room.entity.Room;
import me.polyubomu.smarthome.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public final class RoomController {
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
    public String addRoom(@ShellOption(help = "Room's name") String name) {
        final Room createdRoom = roomService.add(name);

        return "Successfully created new room '"
                + createdRoom.getName()
                + "' with ID "
                + createdRoom.getId();
    }
}
