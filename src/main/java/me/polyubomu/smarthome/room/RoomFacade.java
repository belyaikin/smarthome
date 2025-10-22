package me.polyubomu.smarthome.room;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.EnableableDevice;
import me.polyubomu.smarthome.device.entity.Lightbulb;
import me.polyubomu.smarthome.device.entity.MusicPlayer;
import me.polyubomu.smarthome.device.entity.SecurityCamera;
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
                .stream().filter(device ->
                        ((EnableableDevice) device).isEnabled())
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
                .forEach(Device::operate);
    }

    public void activateStandaloneMode() {
        List<Device> enabledDevices = getDevices(true);
        List<Device> disabledDevices = getDevices(false);

        enabledDevices.forEach(Device::operate);

        activateSecuritySystem(disabledDevices);

        enabledDevices.forEach(device -> deviceService.add(device));
        disabledDevices.forEach(device -> deviceService.add(device));
    }

    public void activateNightMode(Long roomId) {
        List<Device> enabledDevices = getDevicesInRoom(roomId, true);
        List<Device> disabledDevices = getDevicesInRoom(roomId, false);

        activateSecuritySystem(disabledDevices);

        for (Device device : enabledDevices) {
            if (device instanceof Lightbulb) {
                device.operate();
            }
        }

        enabledDevices.forEach(device -> deviceService.add(device));
        disabledDevices.forEach(device -> deviceService.add(device));
    }

    public void activatePartyMode(Long roomId, String music) {
        List<Device> disabledMusicPlayers = getDevicesInRoom(roomId, false)
                .stream()
                .filter(device -> device instanceof MusicPlayer)
                .toList();

        List<Device> enabledMusicPlayers = getDevicesInRoom(roomId, false)
                .stream()
                .filter(device -> device instanceof MusicPlayer)
                .toList();

        List<Device> lightbulbs = getDevicesInRoom(roomId)
                .stream()
                .filter(device -> device instanceof Lightbulb)
                .toList();

        disabledMusicPlayers.forEach(device -> {
                    device.operate();
                    ((MusicPlayer) device).setMusic(music);
                });

        enabledMusicPlayers
                .forEach(device -> ((MusicPlayer) device).setMusic(music));

        lightbulbs
                .forEach(device -> ((Lightbulb) device).setBrightness(1f));

        disabledMusicPlayers.forEach(musicPlayer -> deviceService.add(musicPlayer));
        enabledMusicPlayers.forEach(musicPlayer -> deviceService.add(musicPlayer));
        lightbulbs.forEach(lightbulb -> deviceService.add(lightbulb));
    }
}
