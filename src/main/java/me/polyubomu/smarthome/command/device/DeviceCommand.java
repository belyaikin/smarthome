package me.polyubomu.smarthome.command.device;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.factory.DeviceFactoryRegistry;
import me.polyubomu.smarthome.service.DeviceService;
import me.polyubomu.smarthome.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@Command(command = "device")
public final class DeviceCommand {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private DeviceFactoryRegistry factoryRegistry;

    @Command(command = "list")
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

    @Command(command = "add")
    public String addDevice(
            @ShellOption(help = "The type of device, for example 'lightbulb'") String type,
            @ShellOption(help = "Name of new device") String name,
            @ShellOption(help = "Room ID that device will be assigned to") Long roomId) {

        Device device = factoryRegistry.getFactory(type).createDevice();

        device.setName(name);
        device.setRoom(roomService.get(roomId));

        final Device createdDevice = deviceService.saveOrUpdate(device);

        return "Successfully added device "
                + createdDevice.getName()
                + " with ID "
                + createdDevice.getId();
    }

    @Command(command = "operate")
    public String operate(@ShellOption Long id) {
        return id + ": " + deviceService.operate(id);
    }
}
