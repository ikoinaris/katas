package katas.bank.interfaces;

import katas.bank.model.Customer;

import java.util.HashMap;
import java.util.Map;

public interface Actions {

    Map<Integer, Customer> customers = new HashMap<>();

    void selectAction();

    void login();
}
