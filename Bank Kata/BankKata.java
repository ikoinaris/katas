import katas.bank.actions.CustomerActions;
import katas.bank.actions.EmployeeActions;

import java.io.Console;

public class BankKata {
    private static void selectAction() {
        //Console console = System.console();
        int action = Integer.parseInt(System.console().readLine("Select 1 if you are an employee or 2 if you are a customer: "));
        switch (action) {
            case 1 -> new EmployeeActions().selectAction();
            case 2 -> new CustomerActions().selectAction();
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Banking Kata \n Choose one of the following actions: ");
        selectAction();
    }
}
