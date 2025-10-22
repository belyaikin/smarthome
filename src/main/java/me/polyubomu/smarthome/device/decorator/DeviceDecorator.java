package me.polyubomu.smarthome.device.decorator;

import me.polyubomu.smarthome.device.Device;

public abstract class DeviceDecorator extends Device {
    protected final Device device;

    protected DeviceDecorator(Device device) {
        this.device = device;
    }
}
