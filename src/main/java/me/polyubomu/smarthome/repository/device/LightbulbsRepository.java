package me.polyubomu.smarthome.repository.device;

import me.polyubomu.smarthome.device.entity.Lightbulb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightbulbsRepository extends JpaRepository<Lightbulb, Long> {
}
