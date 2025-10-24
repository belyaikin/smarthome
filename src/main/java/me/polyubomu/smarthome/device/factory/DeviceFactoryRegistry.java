package me.polyubomu.smarthome.device.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DeviceFactoryRegistry {
    public Map<String, DeviceFactory> factories = new HashMap<>();

    @Autowired
    public DeviceFactoryRegistry(List<DeviceFactory> factories) {
        for (DeviceFactory factory : factories) {
            String key = factory.getClass().getSimpleName()
                    .replace("Factory", "")
                    .toLowerCase();

            this.factories.put(key, factory);
        }
    }

    public DeviceFactory getFactory(String type) {
        DeviceFactory factory = factories.get(type.toLowerCase());

        if (factory == null)
            throw new IllegalArgumentException("Unknown device type: " + type);

        return factory;
    }
}
