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

    void createAccount(Customer cust) throws Exception;

    Customer updateAccount(Customer cust) throws Exception;

    void deleteAccount(Customer cust) throws Exception;

    Administrator getAdminAccount(Integer id) throws Exception;

    Customer getAccount(Integer id) throws Exception;

    Administrator[] getAdmins() throws Exception;

    Administrator createAdminAccount(Administrator admin) throws Exception;

    Administrator updateAdminAccount(Administrator admin) throws Exception;

    // customer facing info
    double checkBalance(Customer cust) throws Exception;

    void depositMoney(Customer cust, double amount) throws Exception;

    void withdrawMoney(Customer cust, double amount) throws Exception;

    void transferMoney(Customer source, Customer destination, double amt) throws Exception;

    // loan stuff
    java.util.List<io.github.unawarespecs.bankapp.model.LoanPlan> getLoanPlans() throws Exception;
    void createLoanPlan(io.github.unawarespecs.bankapp.model.LoanPlan plan) throws Exception;
    void deleteLoanPlan(int planId) throws Exception;

    java.util.List<io.github.unawarespecs.bankapp.model.Loan> getLoans(Customer cust) throws Exception;
    void applyForLoan(Customer cust, io.github.unawarespecs.bankapp.model.LoanPlan plan, double amount) throws Exception;
    void payLoan(Customer cust, io.github.unawarespecs.bankapp.model.Loan loan, double amount) throws Exception;
    int getCreditScore(Customer cust) throws Exception;
    void updateCreditScore(Customer cust, int score) throws Exception;

    java.util.List<io.github.unawarespecs.bankapp.model.Loan> getAllActiveLoans() throws Exception;
    java.util.List<io.github.unawarespecs.bankapp.model.Loan> searchActiveLoans(String query) throws Exception;
}
