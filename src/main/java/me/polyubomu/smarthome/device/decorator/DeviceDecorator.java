package me.polyubomu.smarthome.device.decorator;

import me.polyubomu.smarthome.device.Device;

public abstract class DeviceDecorator extends Device {
    protected final Device device;

    public DeviceDecorator(Device device) {
        this.device = device;
    }
}
