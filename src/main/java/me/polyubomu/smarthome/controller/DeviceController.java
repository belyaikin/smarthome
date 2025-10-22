package me.polyubomu.smarthome.controller;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.factory.DeviceFactory;
import me.polyubomu.smarthome.service.DeviceService;
import me.polyubomu.smarthome.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public final class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private RoomService roomService;

    @ShellMethod(key = "devices")
    public String allDevices(@ShellOption(defaultValue = "") Long roomId) {
        StringBuilder devices = new StringBuilder();

        if (roomId == null|| roomId.toString().isBlank()) {
            System.out.println("All devices in all rooms: \n");

            for (Device device : deviceService.getAll()) {
                devices
                        .append(device.getId())
                        .append(": ")
                        .append(device.getName())
                        .append(" -> ").append(device.getRoom().getName())
                        .append("\n");
            }
        }
        else {
            System.out.println("All devices in " + roomService.get(roomId).getName());

            for (Device device : deviceService.getAll(roomId)) {
                devices
                        .append(device.getId())
                        .append(": ")
                        .append(device.getName())
                        .append(" -> ").append(device.getRoom().getName())
                        .append("\n");
            }
        }

        return devices.toString();
    }

    @ShellMethod(
            key = "add-device",
            value = "Creates and registers new device"
    )
    public String addDevice(
            @ShellOption(help = "The type of device, for example 'lightbulb'") String type,
            @ShellOption(help = "Name of new device") String name,
            @ShellOption(help = "Room ID that device will be assigned to") Long roomId) {
        Device device = DeviceFactory.createDevice(type);

        device.setName(name);
        device.setRoom(roomService.get(roomId));

        final Device createdDevice = deviceService.add(device);

        return "Successfully added device "
                + createdDevice.getName()
                + " with ID "
                + createdDevice.getId();
    }

    @ShellMethod
    public String operate(@ShellOption Long id) {
        return id + ": " + deviceService.operate(id);
    }
}
