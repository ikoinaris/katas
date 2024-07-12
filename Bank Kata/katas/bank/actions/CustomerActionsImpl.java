package katas.bank.actions;

import katas.bank.interfaces.CustomerActions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerActionsImpl implements CustomerActions {

    private Integer balance;
    private List<String[]> transactions = new ArrayList<>();
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private boolean backToMainMenu = false;

    public void deposit() {
        System.out.println("Enter amount to deposit: ");
        try {
            var amount = Integer.parseInt(bufferedReader.readLine());
            balance += amount;
            transactions.add(new String[] { String.valueOf(LocalDate.now()), "+" + amount, String.valueOf(balance)});
            System.out.println("Deposit is successful");
            selectAction();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void withdraw() {
        if (balance == 0) {
            System.out.println("Your current balance in empty and you can perform any withdraw. Try deposit some money first.");
            selectAction();
        } try {
            System.out.println("Enter amount to withdraw: ");
            var amount = Integer.parseInt(bufferedReader.readLine());
            while (balance < amount) {
                System.out.println("The amount you're trying to withdraw is greater than your current balance");
                amount = Integer.parseInt(bufferedReader.readLine());
            }
            balance -= amount;
            transactions.add(new String[] { String.valueOf(LocalDate.now()), "-" + amount, String.valueOf(balance)});
            System.out.println("Withdraw is successful");
            selectAction();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void showAllTransactions() {
        transactions.add(0, new String[] {"Date", "Amount", "Balance"});
        for(String[] transaction : transactions) {
            System.out.println(Arrays.toString(transaction));
        }
        selectAction();
    }

    public void login() {
        var customerId = -1;
        var MAX_ATTEMPTS = 3;
        var attempt = 0;
        try {
            // First Step : Customer ID
            while(attempt < MAX_ATTEMPTS) {
                System.out.println(String.format("Please enter your customer id (remaining attempts: %d): ", MAX_ATTEMPTS - attempt));
                customerId = Integer.parseInt(bufferedReader.readLine());
                if(customers.containsKey(customerId)) {
                    break;
                } else {
                    attempt++;
                    System.out.println("Customer id not found");
                    if(attempt == MAX_ATTEMPTS) {
                        System.out.println("Login attempt failed, exiting system...");
                        System.exit(0);
                    }
                }
            }
            // Second Step: Customer PIN
            while(attempt < MAX_ATTEMPTS) {
                System.out.println(String.format("Please enter your PIN (remaining attempts: %d): ", MAX_ATTEMPTS - attempt));
                var pinGiven = Integer.parseInt(bufferedReader.readLine());
                var customer = customers.get(customerId);
                if(customer.getPin().equals(pinGiven)) {
                    System.out.println(String.format("Login successful welcome %s", customer.getFirstName()));
                    selectAction();
                    return;
                } else {
                    attempt++;
                    if(attempt == MAX_ATTEMPTS) {
                        System.out.println("Login attempt failed, exiting system...");
                        System.exit(0);
                    }
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void selectAction() {
        while(!backToMainMenu) {
            try {
                System.out.println("1 - Deposit 2 - Withdraw 3 - Show all transactions 4 - Back o Main Menu: ");
                var action = Integer.parseInt(bufferedReader.readLine());
                switch (action) {
                    case 1 -> deposit();
                    case 2 -> withdraw();
                    case 3 -> showAllTransactions();
                    case 4 -> backToMainMenu = true;
                    default -> System.out.println("Invalid action. Try again: ");
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public Integer getBalance() {
        return balance;
    }

    public List<String[]> getTransactions() {
        return transactions;
    }
}
