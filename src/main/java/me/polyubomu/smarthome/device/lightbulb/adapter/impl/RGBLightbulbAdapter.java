package me.polyubomu.smarthome.device.lightbulb.adapter.impl;

import me.polyubomu.smarthome.device.lightbulb.adapter.LightbulbAdapter;
import me.polyubomu.smarthome.device.lightbulb.driver.RGBLightbulbDriver;

public final class RGBLightbulbAdapter implements LightbulbAdapter {
    private final RGBLightbulbDriver driver;

    public RGBLightbulbAdapter(RGBLightbulbDriver driver) {
        this.driver = driver;
    }

    @Override
    public void operate() {
        driver.receiveEnergy(5);
    }
}
