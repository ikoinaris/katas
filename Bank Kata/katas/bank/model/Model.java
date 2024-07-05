package katas.bank.model;

public class Model {

    private String firstName;
    private String lastName;

    public Model (String name, String surname) {
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
