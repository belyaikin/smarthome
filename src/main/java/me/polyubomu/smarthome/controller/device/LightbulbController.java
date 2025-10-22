package me.polyubomu.smarthome.controller.device;

import me.polyubomu.smarthome.device.entity.Lightbulb;
import me.polyubomu.smarthome.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public final class LightbulbController {
    @Autowired
    private DeviceService service;

    @ShellMethod(
            key = "set-color",
            value = "Changes the lightbulb's color"
    )
    public String setColor(
            @ShellOption(help = "Lightbulb's ID") Long id,
            @ShellOption(help = "Lightbulb's new color") String newColor) {
        Lightbulb lightbulb = (Lightbulb) service.get(id);

        lightbulb.setColor(newColor);

        service.saveOrUpdate(lightbulb);

        return lightbulb.getName()
                + "'s new color is "
                + lightbulb.getColor();
    }
}
