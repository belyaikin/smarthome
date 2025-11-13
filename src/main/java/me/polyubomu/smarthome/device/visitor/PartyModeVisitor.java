package me.polyubomu.smarthome.device.visitor;

import me.polyubomu.smarthome.device.entity.Lightbulb;
import me.polyubomu.smarthome.device.entity.MusicPlayer;
import me.polyubomu.smarthome.device.entity.SecurityCamera;
import me.polyubomu.smarthome.device.entity.Thermostat;

public class PartyModeVisitor implements DeviceVisitor {

    private final String music;

    public PartyModeVisitor(String music) {
        this.music = music;
    }

    @Override
    public void visit(Lightbulb lightbulb) {
        lightbulb.setBrightness(1.0f);
        System.out.println("Party mode: Lightbulb " + lightbulb.getName() + " brightness set to " + lightbulb.getBrightness());
    }

    @Override
    public void visit(Thermostat thermostat) {
        thermostat.setTemperature(22.0f);
        System.out.println("Party mode: Thermostat " + thermostat.getName() + " temperature set to " + thermostat.getTemperature());
    }

    @Override
    public void visit(MusicPlayer musicPlayer) {
        musicPlayer.setMusic(music);
        System.out.println("Party mode: Music player " + musicPlayer.getName() + " is now playing: " + music);
    }

    @Override
    public void visit(SecurityCamera securityCamera) {
        securityCamera.operate();
        System.out.println("Party mode: Security camera " + securityCamera.getName() + " is now active.");
    }
}
