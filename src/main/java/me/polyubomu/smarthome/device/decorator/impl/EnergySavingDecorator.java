package me.polyubomu.smarthome.device.decorator.impl;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.decorator.DeviceDecorator;
import me.polyubomu.smarthome.device.entity.Lightbulb;

public final class EnergySavingDecorator extends DeviceDecorator {
    public EnergySavingDecorator(Device device) {
        super(device);
    }

    @Override
    public String operate() {
        if (device instanceof Lightbulb) {
            ((Lightbulb) device).setBrightness(((Lightbulb) device).getBrightness() / 1.5f);
        }

        return "[ENERGY SAVING] " + device.operate();
    }
}
