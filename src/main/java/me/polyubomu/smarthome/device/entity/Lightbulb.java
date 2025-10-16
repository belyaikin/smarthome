package me.polyubomu.smarthome.device.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.polyubomu.smarthome.device.TurnableDevice;

@Entity
@Table(name = "lightbulbs")
@NoArgsConstructor
public class Lightbulb extends TurnableDevice {
    @Column
    public String color;

    @Column
    public float brightness;

    public Lightbulb(String color, float brightness) {
        this.color = color;
        this.brightness = brightness;
    }

    @Override
    protected String getEnabledMessage() {
        return "";
    }

    @Override
    protected String getDisabledMessage() {
        return "";
    }
}
