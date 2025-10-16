package me.polyubomu.smarthome.device.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.polyubomu.smarthome.device.EnableableDevice;

@Entity
@Table(name="thermostats")
@NoArgsConstructor
@Getter
@Setter
public class Thermostat extends EnableableDevice {
    @Column
    private float temperature;

    @Override
    protected String getEnabledMessage() {
        return "Enabling the thermostat (" + getId() + ") with temperature " + temperature + " celsius";
    }

    @Override
    protected String getDisabledMessage() {
        return "Disabling the thermostat (" + getId() + ")";
    }
}
