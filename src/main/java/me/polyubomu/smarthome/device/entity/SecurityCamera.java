package me.polyubomu.smarthome.device.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import me.polyubomu.smarthome.device.EnableableDevice;
import me.polyubomu.smarthome.device.visitor.DeviceVisitor;

@Entity
@Table(name = "security_cameras")
public class SecurityCamera extends EnableableDevice {
    @Override
    public String getEnabledMessage() {
        return "Enabled security camera in room " + getRoom();
    }

    @Override
    public String getDisabledMessage() {
        return "Disabled security camera in room " + getRoom();
    }

    @Override
    public void accept(DeviceVisitor visitor){
        visitor.visit(this);
    }
}
