package me.polyubomu.smarthome.device.factory;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.entity.Lightbulb;
import me.polyubomu.smarthome.device.entity.SecurityCamera;
import me.polyubomu.smarthome.device.entity.Thermostat;

public final class DeviceFactory {
    public static Device createDevice(String type) {
        return switch (type.toLowerCase()) {
            case "lightbulb" -> new Lightbulb("White", 10.0f);
            case "thermostat" -> new Thermostat();
            case "camera" -> new SecurityCamera();
            default -> throw new IllegalArgumentException();
        };
    }
}
