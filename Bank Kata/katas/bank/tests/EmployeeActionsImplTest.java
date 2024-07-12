package katas.bank.tests;

import katas.bank.actions.EmployeeActionsImpl;
import katas.bank.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class EmployeeActionsImplTest {

    @InjectMocks
    private EmployeeActionsImpl employeeActions;

    @Mock
    private BufferedReader bufferedReader;

    @Mock
    private PrintStream printStream;
    private Map<Integer, Customer> customers;

    @BeforeEach
    public void setUp() {
        customers = new HashMap<>();
        employeeActions = new EmployeeActionsImpl();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Test
    public void testShowAllCustomers_noCustomers() throws IOException {
        // Arrange
        when(customers.isEmpty()).thenReturn(true);

        // Act
        employeeActions.showAllCustomers();

        // Assert
        verify(printStream).println("There are no saved accounts. Create one to continue");
    }

    @Test
    public void testShowAllCustomers_withCustomers() throws IOException {
        // Arrange
        Customer customer = new Customer("John", "Doe", 1234, LocalDate.now());
        customers.put(1, customer);

        // Act
        employeeActions.showAllCustomers();

        // Assert
        verify(printStream).println(anyString());
    }

    @Test
    public void testCreateCustomer() throws IOException {
        // Arrange
        when(bufferedReader.readLine())
                .thenReturn("John")
                .thenReturn("Doe");

        // Act
        employeeActions.createCustomer();

        // Assert
        assertTrue(customers.size() == 1);
        verify(printStream).println("Customer created successfully");
    }

    @Test
    public void testDeleteCustomer() throws IOException {
        // Arrange
        Customer customer = new Customer("John", "Doe", 1234, LocalDate.now());
        customers.put(1, customer);
        when(bufferedReader.readLine()).thenReturn("1");

        // Act
        employeeActions.deleteCustomer();

        // Assert
        assertTrue(customers.isEmpty());
    }

    @Test
    public void testSelectAction_showAllCustomers() throws IOException {
        // Arrange
        when(bufferedReader.readLine()).thenReturn("1");
        //doNothing().when(employeeActions).showAllCustomers();

        // Act
        employeeActions.selectAction();

        // Assert
        verify(employeeActions).showAllCustomers();
    }

    @Test
    public void testSelectAction_createCustomer() throws IOException {
        // Arrange
        when(bufferedReader.readLine()).thenReturn("2");
        doNothing().when(employeeActions).createCustomer();

        // Act
        employeeActions.selectAction();

        // Assert
        verify(employeeActions).createCustomer();
    }

    @Test
    public void testSelectAction_deleteCustomer() throws IOException {
        // Arrange
        when(bufferedReader.readLine()).thenReturn("3");
        doNothing().when(employeeActions).deleteCustomer();

        // Act
        employeeActions.selectAction();

        // Assert
        verify(employeeActions).deleteCustomer();
    }
}