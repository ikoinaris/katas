package katas.bank.model;

import katas.bank.interfaces.EmployeeActions;

public class Employee extends Person {

    private EmployeeActions employeeActions;

    public Employee(EmployeeActions employeeActions) {
        this.employeeActions = employeeActions;
    }

    @Override
    public void performAction() { employeeActions.selectAction(); }
}
