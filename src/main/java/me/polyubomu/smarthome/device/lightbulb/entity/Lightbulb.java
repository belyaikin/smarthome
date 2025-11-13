package me.polyubomu.smarthome.device.lightbulb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import me.polyubomu.smarthome.device.EnableableDevice;

@Entity
@Table(name = "lightbulbs")
public class Lightbulb extends EnableableDevice {
    public Lightbulb() {}

    @Override
    protected String getEnabledMessage() {
        return "Enabled lightbulb";
    }

    @Override
    protected String getDisabledMessage() {
        return "Disabled lightbulb";
    }
}
