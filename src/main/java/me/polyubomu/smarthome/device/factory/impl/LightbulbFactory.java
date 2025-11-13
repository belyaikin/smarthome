package me.polyubomu.smarthome.device.factory.impl;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.lightbulb.entity.Lightbulb;
import me.polyubomu.smarthome.device.factory.DeviceFactory;
import org.springframework.stereotype.Component;

@Component
public class LightbulbFactory implements DeviceFactory {
    @Override
    public Device createDevice() {
        return new Lightbulb("White", 10.0f);
    }
}
