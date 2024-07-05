package katas.bank.model;

import katas.bank.interfaces.CustomerActions;

import java.time.LocalDate;

public class Customer extends Person {

    private CustomerActions customerActions;

    private Integer pin;

    private LocalDate createdAt;

    public Customer(CustomerActions customerActions) {
        this.customerActions = customerActions;
    }

    public Customer(String firstName, String lastName, int customerPin, LocalDate dateOfCreation) {
        super(firstName, lastName);
        this.pin = customerPin;
        this.createdAt = dateOfCreation;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Integer getPin() {
        return pin;
    }

    @Override
    public void performAction() {
        customerActions.login();
    }
}
