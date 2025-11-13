package me.polyubomu.smarthome.device.lightbulb.adapter.impl;

import me.polyubomu.smarthome.device.lightbulb.adapter.LightbulbAdapter;
import me.polyubomu.smarthome.device.lightbulb.driver.IncandescentLightbulbDriver;

public final class IncandescentLightbulbAdapter implements LightbulbAdapter {
    private final IncandescentLightbulbDriver driver;

    public IncandescentLightbulbAdapter(IncandescentLightbulbDriver driver) {
        this.driver = driver;
    }

    @Override
    public void operate() {
        driver.receiveVoltage(10);
    }
}
