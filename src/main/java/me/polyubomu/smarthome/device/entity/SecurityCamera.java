package me.polyubomu.smarthome.device.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import me.polyubomu.smarthome.device.TurnableDevice;

@Entity
@Table(name = "security_cameras")
public class SecurityCamera extends TurnableDevice {
    @Override
    protected String getEnabledMessage() {
        return "";
    }

    @Override
    protected String getDisabledMessage() {
        return "";
    }
}
