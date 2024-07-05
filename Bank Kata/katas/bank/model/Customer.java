package katas.bank.model;

import java.time.LocalDate;

public class Customer extends Model {

    private LocalDate createdAt;

    public Customer(String firstName, String lastName, LocalDate dateOfCreation) {
        super(firstName, lastName);
        createdAt = dateOfCreation;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
