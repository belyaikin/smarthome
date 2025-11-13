package me.polyubomu.smarthome.device.strategy;

import me.polyubomu.smarthome.device.Device;

public interface DeviceOperationStrategy {
    String performOperation(Device device);
}
