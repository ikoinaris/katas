package parrot.interfaces;

public abstract class Parrot {

    public abstract double getSpeed();

    public abstract String getCry();

    public double getBaseSpeed() { return 12.0; }

    public double getLoadFactor() { return 9.0; }
}
