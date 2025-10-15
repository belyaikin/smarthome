package me.polyubomu.smarthome.repository.device;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.device.entity.Thermostat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThermostatsRepository extends JpaRepository<Thermostat, Long> {
}
