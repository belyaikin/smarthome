package me.polyubomu.smarthome.service;

import me.polyubomu.smarthome.device.Device;
import me.polyubomu.smarthome.repository.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository repository;

    public Device add(Device device) {
        return repository.save(device);
    }

    public List<Device> getAll() {
        return repository.findAll();
    }

    public List<Device> getAll(Long roomId) {
        return repository.findAll()
                .stream()
                .filter(
                device -> Objects.equals(device.getRoom().getId(), roomId))
                .toList();
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
