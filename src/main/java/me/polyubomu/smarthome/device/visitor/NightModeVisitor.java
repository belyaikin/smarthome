package me.polyubomu.smarthome.device.visitor;

import me.polyubomu.smarthome.device.entity.Lightbulb;
import me.polyubomu.smarthome.device.entity.MusicPlayer;
import me.polyubomu.smarthome.device.entity.SecurityCamera;
import me.polyubomu.smarthome.device.entity.Thermostat;

public class NightModeVisitor implements DeviceVisitor{
    public void visit(Lightbulb lightbulb){
        lightbulb.setBrightness(0.1f);
        System.out.println("Night mode: Lightbulb " + lightbulb.getName() + " brightness: " + lightbulb.getBrightness());
    }

    public void visit(Thermostat thermostat){
        thermostat.setTemperature(20.0f);
        System.out.println("Night mode: thermostat " + thermostat.getName() + " temperature: " + thermostat.getTemperature() );
    }

    public void visit(MusicPlayer musicPlayer){
        musicPlayer.operate();
        System.out.println("MusicPlayer visit: " + musicPlayer.getName());
    }

    public void visit(SecurityCamera securityCamera){
        securityCamera.operate();
        System.out.println("SecurityCamera visit: " + securityCamera.getName());
    }
}
