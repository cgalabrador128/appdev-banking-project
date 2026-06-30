package io.github.unawarespecs.bankapp.jfx.serviceimpl;

import io.github.unawarespecs.bankapp.model.Administrator;
import io.github.unawarespecs.bankapp.model.Customer;
import io.github.unawarespecs.bankapp.model.User;
import io.github.unawarespecs.bankapp.service.BankInterface;

public class BankService implements BankInterface {

    static BankService service = null;

    public static BankService getInstance() {
        if (service == null) {
            service = new BankService();
        }
        return service;
    }

    @Override
    public int getAccountNumber(Customer cust) throws NumberFormatException {
        return 0;
    }

    @Override
    public String getOwner(Customer cust) throws Exception {
        return "";
    }

    @Override
    public Customer getCurrentlyLoggedInCustomer() {
        return null;
    }

    @Override
    public void setCurrentlyLoggedInCustomer(Customer cust) {

    }

    @Override
    public Administrator getCurrentlyLoggedInAdmin() {
        return null;
    }

    @Override
    public void setCurrentlyLoggedInAdmin(Administrator admin) {

    }

    @Override
    public User[] getAllUsers() throws Exception {
        return new User[0];
    }

    @Override
    public Customer[] getCustomers() throws Exception {
        return new Customer[0];
    }

    @Override
    public Customer createAccount(Customer cust) throws Exception {
        return null;
    }

    @Override
    public Customer updateAccount(Customer cust) throws Exception {
        return null;
    }

    @Override
    public void deleteAccount(Integer id) throws Exception {

    }

    @Override
    public Administrator getAdminAccount(Integer id) throws Exception {
        return null;
    }

    @Override
    public Customer getAccount(Integer id) throws Exception {
        return null;
    }

    @Override
    public Administrator[] getAdmins() throws Exception {
        return new Administrator[0];
    }

    @Override
    public Administrator createAdminAccount(Administrator admin) throws Exception {
        return null;
    }

    @Override
    public Administrator updateAdminAccount(Administrator admin) throws Exception {
        return null;
    }

    @Override
    public double checkBalance(Customer cust) throws NumberFormatException {
        return 0;
    }

    @Override
    public void depositMoney(Customer cust, double amount) throws NumberFormatException {

    }

    @Override
    public void withdrawMoney(Customer cust, double amount) throws NumberFormatException {

    }

    @Override
    public void transferMoney(Customer source, Customer destination) throws Exception {

    }
}
