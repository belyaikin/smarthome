package me.polyubomu.smarthome.device.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import me.polyubomu.smarthome.device.EnableableDevice;

@Entity
@Table(name="thermostats")
public class Thermostat extends EnableableDevice {
    @Column
    private float temperature;

    public Thermostat() {}

    @Override
    protected String getEnabledMessage() {
        return "Enabling the thermostat (" + getId() + ") with temperature " + temperature + " celsius";
    }

    @Override
    protected String getDisabledMessage() {
        return "Disabling the thermostat (" + getId() + ")";
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
