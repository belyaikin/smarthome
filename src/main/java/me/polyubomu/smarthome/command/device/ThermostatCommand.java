package me.polyubomu.smarthome.command.device;

import me.polyubomu.smarthome.device.entity.Thermostat;
import me.polyubomu.smarthome.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.standard.ShellOption;

@Command(command = "thermostat")
public final class ThermostatCommand {
    @Autowired
    public DeviceService service;

    @Command(command = "temperature")
    public String changeTemperature(
            @ShellOption(help = "Thermostat's ID")  Long id,
            @ShellOption(help = "New temperature") float newTemperature) {
        Thermostat thermostat = (Thermostat) service.get(id);

        thermostat.setTemperature(newTemperature);

        service.saveOrUpdate(thermostat);

        return thermostat.getName()
                + "'s new temperature is "
                + thermostat.getTemperature();
    }
}
