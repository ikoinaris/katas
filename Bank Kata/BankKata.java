import katas.bank.actions.CustomerActions;
import katas.bank.actions.EmployeeActions;

import java.io.*;

public class BankKata {

    private static InputStreamReader streamReader = new InputStreamReader(System.in);
    private static BufferedReader bufferedReader = new BufferedReader(streamReader);

    private static void selectAction() {
        try {
            System.out.println("Select 1 if you are an employee or 2 if you are a customer: ");
            int action = Integer.parseInt(bufferedReader.readLine());
            switch (action) {
                case 1 -> new EmployeeActions().selectAction();
                case 2 -> new CustomerActions().selectAction();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Banking Kata \n Choose one of the following actions: ");
        selectAction();
    }
}
