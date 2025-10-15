package me.polyubomu.smarthome.controller;

import me.polyubomu.smarthome.entity.Device;
import me.polyubomu.smarthome.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/device")
public class DeviceController {
    @Autowired
    public DeviceService service;

    @PostMapping
    public Device create(@RequestBody Device device) {
        return service.create(device);
    }

    @GetMapping
    public Device getById(@RequestParam Long id) {
        return service.findById(id);
    }
}
