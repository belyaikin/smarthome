package me.polyubomu.smarthome.repository.device;

import me.polyubomu.smarthome.device.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
