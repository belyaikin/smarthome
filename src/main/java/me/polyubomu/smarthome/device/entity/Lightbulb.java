package me.polyubomu.smarthome.device.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import me.polyubomu.smarthome.device.EnableableDevice;
import me.polyubomu.smarthome.device.visitor.DeviceVisitor;

@Entity
@Table(name = "lightbulbs")
public class Lightbulb extends EnableableDevice {
    public Lightbulb() {}

    @Column
    private String color;

    @Column
    private float brightness;

    public Lightbulb(String color, float brightness) {
        this.color = color;
        this.brightness = brightness;
    }

    @Override
    public String getEnabledMessage() {
        return "Enabled lightbulb";
    }

    @Override
    public String getDisabledMessage() {
        return "Disabled lightbulb";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getBrightness() {
        return brightness;
    }

    public void setBrightness(float brightness) {
        this.brightness = brightness;
    }

    @Override
    public void accept(DeviceVisitor visitor){
        visitor.visit(this);
    }
}
