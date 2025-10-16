package me.polyubomu.smarthome.device.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import me.polyubomu.smarthome.device.EnableableDevice;

@Entity
@Table(name = "security_cameras")
public class SecurityCamera extends EnableableDevice {
    @Override
    protected String getEnabledMessage() {
        return "Enabled security camera";
    }

    @Override
    protected String getDisabledMessage() {
        return "Disabled security camera";
    }
}
