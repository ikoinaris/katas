package katas.bank.actions;

import katas.bank.model.Customer;

import java.util.HashMap;
import java.util.Map;

public abstract class Actions {

    public Map<Integer, Customer> customers = new HashMap<>();

    public abstract void selectAction();

    public abstract void login();
}
