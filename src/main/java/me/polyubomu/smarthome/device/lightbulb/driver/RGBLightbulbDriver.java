package me.polyubomu.smarthome.device.lightbulb.driver;

public final class RGBLightbulbDriver {
    private int watts;

    public void receiveEnergy(int watts) {
        this.watts = watts;
    }

    public void turnOn() {
        if (watts < 10) {
            System.out.println("Not enough energy!");
        }
        else if (watts > 20) {
            System.out.println("Too much energy!");
        }
    }
}
