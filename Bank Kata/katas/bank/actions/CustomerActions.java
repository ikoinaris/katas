package katas.bank.actions;

import java.io.Console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerActions extends Actions{

    Console console = System.console();
    private int balance;
    private List<String[]> transactions = new ArrayList<>();

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
        var action = Integer.parseInt(console.readLine("1 - Deposit 2 - Withdraw 3 - Show all transactions 4 - Exit: "));
        switch (action) {
            case 1 -> {
                var amount = Integer.parseInt(console.readLine("Enter amount to deposit: "));
                deposit(amount);
            }
            case 2 -> {
                var amount = Integer.parseInt(console.readLine("Enter amount to withdraw: "));
                withdraw(amount);
            }
            case 3 -> showAllTransactions();
            default -> System.exit(0);
        }
    }
}
