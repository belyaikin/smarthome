package me.polyubomu.smarthome.room;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.EnableableDevice;
import me.polyubomu.smarthome.device.entity.Lightbulb;
import me.polyubomu.smarthome.device.entity.MusicPlayer;
import me.polyubomu.smarthome.device.entity.SecurityCamera;
import me.polyubomu.smarthome.device.entity.Thermostat;
import me.polyubomu.smarthome.device.strategy.DeviceContextOperate;
import me.polyubomu.smarthome.device.strategy.DeviceOperationStrategy;
import me.polyubomu.smarthome.device.strategy.TurnOnStrategy;
import me.polyubomu.smarthome.device.visitor.NightModeVisitor;
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

    public void operateDevice(Device device, DeviceOperationStrategy strategy){
        DeviceContextOperate context = new DeviceContextOperate(strategy);
        System.out.println(context.operate(device));
    }

    public void activateStandaloneMode() {
        List<Device> enabledDevices = getDevices(true);
        List<Device> disabledDevices = getDevices(false);

        enabledDevices.forEach(device -> operateDevice(device, new TurnOnStrategy()));

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
                    ((MusicPlayer) device).setMusic(music);
                    System.out.println(device.operate());
        });

        enabledMusicPlayers
                .forEach(device -> ((MusicPlayer) device).setMusic(music));

        lightbulbs
                .forEach(device -> ((Lightbulb) device).setBrightness(1f));

        disabledMusicPlayers.forEach(musicPlayer -> deviceService.saveOrUpdate(musicPlayer));
        enabledMusicPlayers.forEach(musicPlayer -> deviceService.saveOrUpdate(musicPlayer));
        lightbulbs.forEach(lightbulb -> deviceService.saveOrUpdate(lightbulb));
    }
}
