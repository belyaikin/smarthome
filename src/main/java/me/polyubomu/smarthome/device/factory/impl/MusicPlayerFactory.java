package me.polyubomu.smarthome.device.factory.impl;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.entity.MusicPlayer;
import me.polyubomu.smarthome.device.factory.DeviceFactory;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayerFactory implements DeviceFactory {

    @Override
    public Device createDevice() {
        return new MusicPlayer();
    }
}
