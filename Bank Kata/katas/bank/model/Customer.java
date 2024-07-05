package katas.bank.model;

import java.time.LocalDate;

public final class Customer extends Person {

    private final Integer pin;

    private final LocalDate createdAt;

    public Customer(String firstName, String lastName, int customerPin, LocalDate dateOfCreation) {
        super(firstName, lastName);
        pin = customerPin;
        createdAt = dateOfCreation;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Integer getPin() {
        return pin;
    }
}
