package me.polyubomu.smarthome.device.lightbulb.driver;

public final class IncandescentLightbulbDriver {
    private int currentVoltage = 0;

    public void receiveVoltage(int watt) {
        if (watt >= 10) {
            glow();
            return;
        }
        else if (watt < 10) {
            System.out.println("Not enough energy!");
            return;
        }
        else if (watt > 15) {
            System.out.println("Too much energy!");
            return;
        }

        currentVoltage = watt;
    }

    private void glow() {
        System.out.println("I'm glowing with voltage of " + currentVoltage + " watts.");
    }
}
