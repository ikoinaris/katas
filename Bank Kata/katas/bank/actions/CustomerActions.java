package katas.bank.actions;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerActions extends Actions{

    private int balance;
    private List<String[]> transactions = new ArrayList<>();
    private InputStreamReader streamReader = new InputStreamReader(System.in);
    private BufferedReader bufferedReader = new BufferedReader(streamReader);

    public void deposit(int amount) {
        balance += amount;
        transactions.add(new String[] { String.valueOf(LocalDate.now()), "+" + amount, String.valueOf(balance)});
    }

    public void withdraw(int amount) {
        balance -= amount;
        transactions.add(new String[] { String.valueOf(LocalDate.now()), "-" + amount, String.valueOf(balance)});
    }

    public void showAllTransactions() {
        transactions.add(0, new String[] {"Date", "Amount", "Balance"});
        transactions.stream().forEach(System.out::println);
    }

    @Override
    public void selectAction() {
        try {
            System.out.println("1 - Deposit 2 - Withdraw 3 - Show all transactions 4 - Exit: ");
            var action = Integer.parseInt(bufferedReader.readLine());
            switch (action) {
                case 1 -> {
                    System.out.println("Enter amount to deposit: ");
                    var amount = Integer.parseInt(bufferedReader.readLine());
                    deposit(amount);
                }
                case 2 -> {
                    System.out.println("Enter amount to withdraw: ");
                    var amount = Integer.parseInt(bufferedReader.readLine());
                    withdraw(amount);
                }
                case 3 -> showAllTransactions();
                default -> System.exit(0);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
