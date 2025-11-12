package me.polyubomu.smarthome.device.visitor;

import me.polyubomu.smarthome.device.entity.*;

public class DeviceOperationVisitor implements DeviceVisitor {
    public void visit(Lightbulb lightbulb){
        System.out.println("Lightbulb visit: " + lightbulb.getName());
    }

    public void visit(Thermostat thermostat){
        System.out.println("Thermostat visit: " + thermostat.getName());
    }

    public void visit(MusicPlayer musicPlayer){
        System.out.println("MusicPlayer visit: " + musicPlayer.getName());
    }

    public void visit(SecurityCamera securityCamera){
        System.out.println("SecurityCamera visit: " + securityCamera.getName());
    }
}
