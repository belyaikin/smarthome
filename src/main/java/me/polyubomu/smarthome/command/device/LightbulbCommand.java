package me.polyubomu.smarthome.command.device;

import me.polyubomu.smarthome.device.lightbulb.entity.Lightbulb;
import me.polyubomu.smarthome.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@Command(command = "lightbulb")
public final class LightbulbCommand {
    @Autowired
    private DeviceService service;

    @Command(command = "color")
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

    @ShellMethod(
            key = "set-brightness",
            value = "Changes the lightbulb's brightness"
    )
    public String setBrightness(
            @ShellOption(help = "Lightbulb's ID") Long id,
            @ShellOption(help = "Lightbulb's brightness") float brightness
    ) {
        Lightbulb lightbulb = (Lightbulb) service.get(id);

        lightbulb.setBrightness(brightness);

        service.saveOrUpdate(lightbulb);

        return lightbulb.getName()
                + "'s new brightness is "
                + lightbulb.getBrightness();
    }
}
