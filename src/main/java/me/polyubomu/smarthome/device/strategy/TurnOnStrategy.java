package me.polyubomu.smarthome.device.strategy;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.EnableableDevice;

public class TurnOnStrategy implements DeviceOperationStrategy {
    @Override
    public String performOperation(Device device) {
        if (device instanceof EnableableDevice) {
            EnableableDevice enableableDevice = (EnableableDevice) device;
            enableableDevice.setEnabled(true);
            return enableableDevice.getEnabledMessage();
        }
        return "Operation not supported for this device";
    }
}