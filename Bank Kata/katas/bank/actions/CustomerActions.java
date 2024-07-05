package katas.bank.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerActions extends Actions{

    private int balance;
    private List<String[]> transactions = new ArrayList<>();
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

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
        try {
            System.out.println("Enter your id to login: ");
            var id = Integer.parseInt(bufferedReader.readLine());
            while (!customers.containsKey(id)) {
                System.out.println("Wrong customer id, try again: ");
                id = Integer.parseInt(bufferedReader.readLine());
            }
            var failedAttempts = 0;
            while(failedAttempts < 3) {
                System.out.println(String.format("Login failed. Try again. Attempts remaining: %d", failedAttempts));
                failedAttempts++;
            }
            if(customers.containsKey(id)) {
                System.out.println(String.format("Login successful welcome %s", customers.get(id).getFirstName()));
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void selectAction() {
        try {
            System.out.println("1 - Deposit 2 - Withdraw 3 - Show all transactions 4 - Exit: ");
            var action = Integer.parseInt(bufferedReader.readLine());
            switch (action) {
                case 1 -> deposit();
                case 2 -> withdraw();
                case 3 -> showAllTransactions();
                case 4 -> System.exit(0);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
