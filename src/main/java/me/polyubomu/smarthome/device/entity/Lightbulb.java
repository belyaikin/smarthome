package me.polyubomu.smarthome.device.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.polyubomu.smarthome.device.EnableableDevice;

@Entity
@Table(name = "lightbulbs")
@NoArgsConstructor
@Getter
@Setter
public class Lightbulb extends EnableableDevice {
    @Column
    private String color;

    @Column
    private float brightness;

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
