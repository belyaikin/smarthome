package me.polyubomu.smarthome.service;

import me.polyubomu.smarthome.entity.Device;
import me.polyubomu.smarthome.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository repository;

    public Device create(Device device) {
        return repository.save(device);
    }

    public Device findById(long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("idk"));
    }
}
