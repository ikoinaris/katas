package katas.bank.tests;

import katas.bank.actions.CustomerActionsImpl;
import katas.bank.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class CustomerActionsImplTest {

    private CustomerActionsImpl customerActions;
    private BufferedReader bufferedReader;
    private Map<Integer, Customer> customers;

    @BeforeEach
    public void setUp() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        customers = new HashMap<>();
        customers.put(1, new Customer("John", "Doe", 1234, LocalDate.now()));
        customerActions = new CustomerActionsImpl();
    }

    @Test
    public void deposit() {
        bufferedReader = new BufferedReader(new StringReader("100\n"));
        customerActions.deposit();
        assertEquals(Optional.of(100), customerActions.getBalance());
        assertEquals(1, customerActions.getTransactions().size());
    }

    @Test
    void withdraw() {
        bufferedReader = new BufferedReader(new StringReader("50\n100\n"));
        customerActions = new CustomerActionsImpl();
        customerActions.deposit();
        customerActions.withdraw();
        assertEquals(Optional.of(0), customerActions.getBalance());
        assertEquals(2, customerActions.getTransactions().size());
    }

    @Test
    void showAllTransactions() {
    }

    @Test
    void login() {
    }

    @Test
    void selectAction() {
    }
}