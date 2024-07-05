package katas.bank.actions;

import katas.bank.model.Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Random;

public class EmployeeActions extends Actions {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void showAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("There are no saved accounts. Create one to continue");
        } else {
            customers.forEach((id, customer) -> { System.out.println(String.format("Customer Id: %d Customer : %s %s Created at: %s",
                    id, customer.getFirstName(), customer.getLastName(), customer.getCreatedAt()));
            });
        }
        selectAction();
    }

    public void createCustomer() {
        try {
            System.out.println("Enter new customer's first name: ");
            var customerFirstName = bufferedReader.readLine();
            System.out.println("Enter new customer's last name: ");
            var customerLastName = bufferedReader.readLine();
            var newCustomerId = generateCustomerId();
            while (customers.containsKey(newCustomerId)) {
                newCustomerId = generateCustomerId();
            }
            var newCustomerPin = generateCustomerPIN();
            var newCustomer = new Customer(customerFirstName, customerLastName, newCustomerPin, LocalDate.now());
            customers.put(newCustomerId, newCustomer);
            System.out.println("Customer created successfully");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        selectAction();
    }

    public void deleteCustomer() {
        try {
            System.out.println("Enter id of customer: ");
            var customerId = Integer.parseInt(bufferedReader.readLine());
            while (!customers.containsKey(customerId)) {
                System.out.println(String.format("There is no customer with id %s please try again: ", customerId));
                customerId = Integer.parseInt(bufferedReader.readLine());
            } customers.remove(customerId);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        selectAction();
    }

    public void selectAction() {
        try {
            System.out.println("1 - Show all customers 2 - Create new customer 3 - Delete Customer 4 - Exit: ");
            var action = Integer.parseInt(bufferedReader.readLine());
            switch (action) {
                case 1 -> showAllCustomers();
                case 2 -> createCustomer();
                case 3 -> deleteCustomer();
                case 4 -> System.exit(0);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public void login() {
        // TODO: login for employee
    }

    private int generateCustomerId() {
        return 1000 + new Random().nextInt(9000);
    }

    private int generateCustomerPIN() {
        return 10000 + new Random().nextInt(99999);
    }
}
