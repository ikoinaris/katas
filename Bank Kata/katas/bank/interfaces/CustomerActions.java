package katas.bank.interfaces;

public interface CustomerActions extends Actions {

    void deposit();

    void withdraw();

    void showAllTransactions();
}
