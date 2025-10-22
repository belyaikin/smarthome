package me.polyubomu.smarthome.room;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.EnableableDevice;
import me.polyubomu.smarthome.device.entity.Lightbulb;
import me.polyubomu.smarthome.device.entity.MusicPlayer;
import me.polyubomu.smarthome.device.entity.SecurityCamera;
import me.polyubomu.smarthome.device.entity.Thermostat;
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

    private List<Device> getDevices(Long roomId, boolean enabled) {
        return deviceService.getAll(roomId)
                .stream()
                .filter(device -> (device instanceof EnableableDevice
                        && enabled) == ((EnableableDevice) device).isEnabled())
                .toList();
    }

    public void activateNightMove(Long roomId) {
        List<Device> enabledDevices = getDevices(roomId, true);
        List<Device> disabledDevices = getDevices(roomId, false);

        System.out.println(enabledDevices);
        System.out.println(disabledDevices);

        for (Device device : enabledDevices) {
            ((Lightbulb) device).setBrightness(0.2f);
            ((Thermostat) device).setTemperature(24.0f);
        }

        for (Device device : disabledDevices) {
            device.operate();
        }

        enabledDevices.forEach(device -> deviceService.add(device));
        disabledDevices.forEach(device -> deviceService.add(device));
    }
}
