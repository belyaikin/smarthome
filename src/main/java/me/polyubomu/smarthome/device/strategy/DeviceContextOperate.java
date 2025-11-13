package me.polyubomu.smarthome.device.strategy;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.strategy.DeviceOperationStrategy;

public class DeviceContextOperate {
    private DeviceOperationStrategy strategy;

    public DeviceContextOperate(DeviceOperationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DeviceOperationStrategy strategy) {
        this.strategy = strategy;
    }

    public String operate(Device device) {
        return strategy.performOperation(device);
    }
}
