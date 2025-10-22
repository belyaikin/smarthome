package me.polyubomu.smarthome.controller.device;

import me.polyubomu.smarthome.device.entity.Thermostat;
import me.polyubomu.smarthome.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public final class ThermostatController {
    @Autowired
    public DeviceService service;

    @ShellMethod(
            key = "set-temperature",
            value = "Changes the temperature on thermostat"
    )
    public String changeTemperature(
            @ShellOption(help = "Thermostat's ID")  Long id,
            @ShellOption(help = "New temperature") float newTemperature) {
        Thermostat thermostat = (Thermostat) service.get(id);

        thermostat.setTemperature(newTemperature);

        service.add(thermostat);

        return thermostat.getName()
                + "'s new temperature is "
                + thermostat.getTemperature();
    }
}
