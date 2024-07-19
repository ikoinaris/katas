package parrot.models;

import parrot.interfaces.Parrot;

public class EuropeanParrot extends Parrot {

    @Override
    public double getSpeed() {
        return getBaseSpeed();
    }

    @Override
    public String getCry() {
        return "Sqoork!";
    }
}
