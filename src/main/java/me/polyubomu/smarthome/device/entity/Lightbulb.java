package me.polyubomu.smarthome.device.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import me.polyubomu.smarthome.device.TurnableDevice;

@Entity
@Table(name = "lightbulbs")
public class Lightbulb extends TurnableDevice {
    @Column
    public String color;

    @Column
    public float brightness;

    @Override
    protected String getEnabledMessage() {
        return "";
    }

    @Override
    protected String getDisabledMessage() {
        return "";
    }
}
