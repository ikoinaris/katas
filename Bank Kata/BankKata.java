import katas.bank.actions.CustomerActionsImpl;
import katas.bank.actions.EmployeeActionsImpl;
import katas.bank.model.Customer;
import katas.bank.model.Employee;

import java.io.*;

public class BankKata {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static EmployeeActionsImpl employeeActions = new EmployeeActionsImpl();
    private static CustomerActionsImpl customerActions = new CustomerActionsImpl();
    private static boolean exit = false;

    private static void selectAction() {
        while(!exit) {
            try {
                System.out.println("1 - Employee 2 - Customer 3 - Exit");
                int action = Integer.parseInt(bufferedReader.readLine());
                switch (action) {
                    case 1 -> {
                        var currentPerson = new Employee(employeeActions);
                        currentPerson.performAction();
                    }
                    case 2 -> {
                        var currentPerson = new Customer(customerActions);
                        currentPerson.performAction();
                    }
                    case 3 -> exit = true;
                    default -> {
                        System.out.println("Invalid action. Try again: ");
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Banking Kata \nChoose one of the following actions: ");
        selectAction();
    }
}
