package me.polyubomu.smarthome.device;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EnableableDevice extends Device {
    @Column
    private boolean enabled;

    protected abstract String getEnabledMessage();
    protected abstract String getDisabledMessage();

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String operate() {
        if (enabled) {
            enabled = false;
            return getDisabledMessage();
        }
        else {
            enabled = true;
            return getEnabledMessage();
        }
    }
}
