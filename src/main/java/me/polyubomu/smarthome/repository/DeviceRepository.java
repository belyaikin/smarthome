package me.polyubomu.smarthome.repository;

import me.polyubomu.smarthome.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
