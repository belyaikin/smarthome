package me.polyubomu.smarthome.device.visitor;

import me.polyubomu.smarthome.device.entity.*;

public interface DeviceVisitor {
    void visit(Lightbulb lightbulb);
    void visit(Thermostat thermostat);
    void visit(MusicPlayer musicPlayer);
    void visit(SecurityCamera securityCamera);
}
