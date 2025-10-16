package me.polyubomu.smarthome.service;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.repository.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository repository;

    public <T extends Device> T add(T device) {
        return repository.save(device);
    }

    public List<Device> getAll() {
        return repository.findAll();
    }

    public Device get(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public String operate(Long id) {
        Device device = repository.findById(id).orElseThrow();

        String onOperateMessage = device.operate();
        repository.save(device);

        return onOperateMessage;
    }
}
