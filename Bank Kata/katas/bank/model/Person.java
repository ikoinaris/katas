package katas.bank.model;

public abstract class Person implements Role {

    private String firstName;
    private String lastName;

    public Person(String name, String surname) {
        firstName = name;
        lastName = surname;
    }

    public Person() {}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public abstract void performAction();
}
