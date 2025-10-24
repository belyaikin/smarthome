package me.polyubomu.smarthome.device.factory;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.entity.Lightbulb;
import me.polyubomu.smarthome.device.entity.SecurityCamera;
import me.polyubomu.smarthome.device.entity.Thermostat;

public interface DeviceFactory {
    Device createDevice();
}
