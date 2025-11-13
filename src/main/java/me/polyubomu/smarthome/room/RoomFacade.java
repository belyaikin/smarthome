package me.polyubomu.smarthome.room;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.EnableableDevice;
import me.polyubomu.smarthome.device.entity.Lightbulb;
import me.polyubomu.smarthome.device.entity.MusicPlayer;
import me.polyubomu.smarthome.device.entity.SecurityCamera;
import me.polyubomu.smarthome.device.entity.Thermostat;
import me.polyubomu.smarthome.device.visitor.NightModeVisitor;
import me.polyubomu.smarthome.device.visitor.PartyModeVisitor;
import me.polyubomu.smarthome.service.DeviceService;
import me.polyubomu.smarthome.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomFacade {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private RoomService roomService;

    private List<Device> getDevices(boolean enabled) {
        return deviceService.getAll()
                .stream()
                .filter(device -> ((EnableableDevice) device).isEnabled() == enabled)
                .toList();
    }

    private List<Device> getDevicesInRoom(Long roomId) {
        return deviceService.getAll(roomId);
    }

    private List<Device> getDevicesInRoom(Long roomId, boolean enabled) {
        return deviceService.getAll(roomId)
                .stream()
                .filter(device -> (device instanceof EnableableDevice
                        && enabled) == ((EnableableDevice) device).isEnabled())
                .toList();
    }

    private void activateSecuritySystem(List<Device> disabledDevices) {
        disabledDevices
                .stream()
                .filter(device -> device instanceof SecurityCamera)
                .forEach(device -> System.out.println(device.operate()));
    }

    public void activateStandaloneMode() {
        List<Device> enabledDevices = getDevices(true);
        List<Device> disabledDevices = getDevices(false);

        enabledDevices
                .forEach(device -> System.out.println(device.operate()));

        activateSecuritySystem(disabledDevices);

        enabledDevices.forEach(device -> deviceService.saveOrUpdate(device));
        disabledDevices.forEach(device -> deviceService.saveOrUpdate(device));
    }

    public void activateNightMode(Long roomId) {
        List<Device> enabledDevices = getDevicesInRoom(roomId, true);
        List<Device> disabledDevices = getDevicesInRoom(roomId, false);

        List<Device> allDevices = getDevicesInRoom(roomId);
        NightModeVisitor nightModeVisitor = new NightModeVisitor();
        activateSecuritySystem(disabledDevices);

        for (Device device : allDevices) {
            device.accept(nightModeVisitor);
        }


        enabledDevices.forEach(device -> deviceService.saveOrUpdate(device));
        disabledDevices.forEach(device -> deviceService.saveOrUpdate(device));
        allDevices.forEach(device -> deviceService.saveOrUpdate(device));
    }

    public void activatePartyMode(Long roomId, String music) {
        PartyModeVisitor partyModeVisitor = new PartyModeVisitor(music);  // Create the visitor with the specified music

        // Get all devices in the room
        List<Device> devicesInRoom = getDevicesInRoom(roomId);

        // Operate on each device using the PartyModeVisitor
        devicesInRoom.forEach(device -> device.accept(partyModeVisitor));  // Each device accepts the visitor

        // Save the updated devices
        devicesInRoom.forEach(device -> deviceService.saveOrUpdate(device));
    }
}
