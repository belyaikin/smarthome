package me.polyubomu.smarthome.shell;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.entity.Lightbulb;
import me.polyubomu.smarthome.device.entity.Thermostat;
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

        return "Successfully created new room '" + name + "'";
    }

    @ShellMethod(key = "devices")
    public String allDevices() {
        System.out.println("All devices:\n");

        StringBuilder devices = new StringBuilder();

        for (Device device : deviceService.getAll()) {
            devices
                    .append(device.getId())
                    .append(": ")
                    .append(device.getName())
                    .append(" -> ").append(device.getRoom().getName())
                    .append("\n");
        }

        return devices.toString();
    }

    @ShellMethod(key = "add-device")
    public String addDevice(@ShellOption String type, @ShellOption String name, @ShellOption Long roomId) {
        Device device;

        switch (type.toLowerCase()) {
            case "lightbulb":
                device = new Lightbulb("White", 10.0f);

                device.setName(name);
                device.setRoom(roomService.get(roomId));

                deviceService.add(device);
                break;
            case "thermostat":
                device = new Thermostat();

                device.setName(name);
                device.setRoom(roomService.get(roomId));

                deviceService.add(device);
                break;
            default:
                return "Invalid type";
        }
        return "Successfully added device "
                + device.getName()
                + " with ID "
                + device.getId();
    }
}
