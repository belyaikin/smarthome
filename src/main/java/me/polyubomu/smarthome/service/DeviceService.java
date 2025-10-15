package me.polyubomu.smarthome.service;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.entity.Thermostat;
import me.polyubomu.smarthome.repository.device.LightbulbsRepository;
import me.polyubomu.smarthome.repository.device.ThermostatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private ThermostatsRepository thermostatsRepository;

    @Autowired
    private LightbulbsRepository lightbulbsRepository;

    public Thermostat createThermostat(Thermostat device) {
        return thermostatsRepository.save(device);
    }

    public Thermostat findThermostatById(long id) {
        return thermostatsRepository.findById(id).orElseThrow(() -> new RuntimeException("idk"));
    }

    public List<Thermostat> getAllThermostats() {
        return thermostatsRepository.findAll();
    }


}
