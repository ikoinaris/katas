package katas.bank.model;

public sealed class Person
    permits Customer, Employee{

    private String firstName;
    private String lastName;

    public Person(String name, String surname) {
        firstName = name;
        lastName = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
