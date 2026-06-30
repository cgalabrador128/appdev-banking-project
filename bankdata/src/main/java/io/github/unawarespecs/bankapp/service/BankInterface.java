package io.github.unawarespecs.bankapp.service;

import io.github.unawarespecs.bankapp.model.Customer;
import io.github.unawarespecs.bankapp.model.Administrator;
import io.github.unawarespecs.bankapp.model.User;

public interface BankInterface {
    int getAccountNumber(Customer cust) throws NumberFormatException;

    String getOwner(Customer cust) throws Exception;

    Customer getCurrentlyLoggedInCustomer();

    void setCurrentlyLoggedInCustomer(Customer cust);

    Administrator getCurrentlyLoggedInAdmin();

    void setCurrentlyLoggedInAdmin(Administrator admin);

    User[] getAllUsers() throws Exception;

    // admin operations
    Customer[] getCustomers() throws Exception;

    Customer createAccount(Customer cust) throws Exception;

    Customer updateAccount(Customer cust) throws Exception;

    void deleteAccount(Integer id) throws Exception;

    Administrator getAdminAccount(Integer id) throws Exception;

    Customer getAccount(Integer id) throws Exception;

    Administrator[] getAdmins() throws Exception;

    Administrator createAdminAccount(Administrator admin) throws Exception;

    Administrator updateAdminAccount(Administrator admin) throws Exception;

    // customer facing info
    double checkBalance(Customer cust) throws NumberFormatException;

    void depositMoney(Customer cust, double amount) throws NumberFormatException;

    void withdrawMoney(Customer cust, double amount) throws NumberFormatException;

    void transferMoney(Customer source, Customer destination) throws Exception;

    // loan stuff
}
