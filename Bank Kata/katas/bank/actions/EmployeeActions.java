package katas.bank.actions;

import katas.bank.model.Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EmployeeActions extends Actions {

    private Map<Integer, Customer> customers = new HashMap<>();
    private InputStreamReader streamReader = new InputStreamReader(System.in);
    private BufferedReader bufferedReader = new BufferedReader(streamReader);

    public void createCustomer() {
        try {
            System.out.println("Enter new customer's first name: ");
            var customerFirstName = bufferedReader.readLine();
            System.out.println("Enter new customer's last name: ");
            var customerLastName = bufferedReader.readLine();
            var customerId = generateCustomerId();
            while (customers.containsKey(customerId)) {
                customerId = generateCustomerId();
            }
            var newCustomer = new Customer(customerFirstName, customerLastName, LocalDate.now());
            customers.put(customerId, newCustomer);
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

    public void showAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("There are no saved accounts.");
        } else {
            customers.forEach((id, customer) -> { System.out.println(String.format("Customer Id: %d Customer : %s %s Created at: %s",
                    id, customer.getFirstName(), customer.getLastName(), customer.getCreatedAt()));
            });
        }
        selectAction();
    }

    @Override
    public void selectAction() {
        try {
            System.out.println("1 - Show all customers 2 - Create new customer 3 - Delete Customer 4 - Exit: ");
            var action = Integer.parseInt(bufferedReader.readLine());
            switch (action) {
                case 1 -> showAllCustomers();
                case 2 -> createCustomer();
                case 3 -> deleteCustomer();
                default -> System.exit(0);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    private int generateCustomerId() {
        return 1000 + new Random().nextInt(9000);
    }

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }
}
