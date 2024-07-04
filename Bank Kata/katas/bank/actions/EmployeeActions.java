package katas.bank.actions;

import katas.bank.model.Customer;

import java.io.Console;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EmployeeActions extends Actions {

    Console console = System.console();
    private Map<Integer, Customer> customers = new HashMap<>();

    public void createCustomer() {
        var customerFirstName = console.readLine("Enter new customer's first name: ");
        var customerLastName = console.readLine("Enter new customer's last name: ");
        var customerId = generateCustomerId();
        while (customers.containsKey(customerId)) {
            customerId = generateCustomerId();
        }
        var newCustomer = new Customer(customerFirstName, customerLastName, LocalDate.now());
        customers.put(customerId, newCustomer);
    }

    public void deleteCustomer() {
        var customerId = Integer.parseInt(console.readLine("Enter id of customer: "));
        while (!customers.containsKey(customerId)) {
            customerId = Integer.parseInt(console.readLine(String.format("There is no customer with id %s please try again: ", customerId)));
        } customers.remove(customerId);
    }

    public void showAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("There are no saved accounts.");
        } else {
            customers.values().forEach(System.out::println);
        }
    }

    @Override
    public void selectAction() {
        var action = Integer.parseInt(console.readLine("1 - Show all customers 2 - Create new customer 3 - Delete Customer 4 - Exit: "));
        switch (action) {
            case 1 -> showAllCustomers();
            case 2 -> createCustomer();
            case 3 -> deleteCustomer();
            default -> System.exit(0);
        }
    }

    private int generateCustomerId() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }
}
