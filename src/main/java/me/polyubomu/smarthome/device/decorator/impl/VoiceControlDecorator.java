package me.polyubomu.smarthome.device.decorator.impl;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.decorator.DeviceDecorator;

public final class VoiceControlDecorator extends DeviceDecorator {
    public VoiceControlDecorator(Device device) {
        super(device);
    }

    @Override
    public String operate() {
        // insert some fancy voice recognition

        return "[VOICE CONTROLLED] " + device.operate();
    }
}
