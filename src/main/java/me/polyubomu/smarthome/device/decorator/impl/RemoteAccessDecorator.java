package me.polyubomu.smarthome.device.decorator.impl;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.decorator.DeviceDecorator;

public final class RemoteAccessDecorator extends DeviceDecorator {
    public RemoteAccessDecorator(Device device) {
        super(device);
    }

    @Override
    public String operate() {
        return "[REMOTE ACCESS] " + device.operate();
    }
}
