package parrot.models;

import parrot.interfaces.Parrot;

public class NorwegianBlueParrot extends Parrot {

    private final boolean isNailed;
    private final double voltage;

    public NorwegianBlueParrot(boolean isNailed, double voltage) {
        this.isNailed = isNailed;
        this.voltage = voltage;
    }

    @Override
    public double getSpeed() { return isNailed ? 0 : getBaseSpeed(voltage); }

    @Override
    public String getCry() { return voltage > 0 ? "Bzzzzzz" : "..."; }

    private double getBaseSpeed(double voltage) { return Math.min(24.0, voltage * getBaseSpeed()); }
}
