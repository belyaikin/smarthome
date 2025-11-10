package me.polyubomu.smarthome.command.room;

import me.polyubomu.smarthome.room.entity.Room;
import me.polyubomu.smarthome.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.standard.ShellOption;

@Command(command = "room")
public final class RoomCommand {
    @Autowired
    private RoomService roomService;

    @Command(command = "list")
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

    @Command(command = "add")
    public String addRoom(@ShellOption(help = "Room's name") String name) {
        final Room createdRoom = roomService.add(name);

        return "Successfully created new room '"
                + createdRoom.getName()
                + "' with ID "
                + createdRoom.getId();
    }
}
