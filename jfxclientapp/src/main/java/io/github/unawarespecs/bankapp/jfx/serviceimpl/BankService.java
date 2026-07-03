package io.github.unawarespecs.bankapp.jfx.serviceimpl;

import io.github.unawarespecs.bankapp.entity.AdministratorData;
import io.github.unawarespecs.bankapp.entity.CustomerData;
import io.github.unawarespecs.bankapp.model.Administrator;
import io.github.unawarespecs.bankapp.model.Customer;
import io.github.unawarespecs.bankapp.model.User;
import io.github.unawarespecs.bankapp.repo.AdminDataRepository;
import io.github.unawarespecs.bankapp.repo.CustDataRepository;
import io.github.unawarespecs.bankapp.service.BankInterface;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.stream.Stream;

@Service
public class BankService implements BankInterface {

    private final AdminDataRepository adminDataRepository;
    private final CustDataRepository custDataRepository;

    private Customer currentlyLoggedInCustomer;
    private Administrator currentlyLoggedInAdmin;

    public BankService(AdminDataRepository adminDataRepository, CustDataRepository custDataRepository) {
        this.adminDataRepository = adminDataRepository;
        this.custDataRepository = custDataRepository;
    }

    @Override
    public int getAccountNumber(Customer cust) throws NumberFormatException {
        return custDataRepository.getCustomerId(cust.getUsername(), cust.getPassword());
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
        List<CustomerData> customerList = custDataRepository.findAll();
        List<AdministratorData> adminList = adminDataRepository.findAll();


        Stream<User> customerStream = customerList.stream().map(cust -> new User(
                cust.getUuid(),
                "Customer",
                false
        ));


        Stream<User> adminStream = adminList.stream().map(admin -> new User(
                admin.getUuid(),
                "Admin",
                true
        ));


        return Stream.concat(customerStream, adminStream)
                .toArray(User[]::new);
    }

    @Override
    public Customer[] getCustomers() throws Exception {
        List<CustomerData> data = custDataRepository.findAll();

        Customer[] customers = data.stream().map(
                cust -> new Customer(
                        cust.getUuid(),
                        cust.getUsername(),
                        cust.getPassword(),
                        "Customer",
                        false,
                        cust.getId(),
                        cust.getBalance(),
                        cust.getPin(),
                        cust.isAccountFrozen()
                )).toArray(Customer[]::new);
        return customers;
    }

    @Override
    public void createAccount(Customer cust) throws Exception {
        CustomerData customerData = new CustomerData();
        customerData.setUuid(cust.getUuid());
        customerData.setUsername(cust.getUsername());
        customerData.setPassword(cust.getPassword());
        customerData.setBalance(cust.getBalance());
        customerData.setPin(cust.getPin());
        customerData.setAccountFrozen(cust.isAccountFrozen());
        if (cust.getId() != 0){
            customerData.setId(cust.getId());
        }
        custDataRepository.save(customerData);
    }

    @Override
    public Customer updateAccount(Customer cust) throws Exception {
        Optional<CustomerData> existingData = custDataRepository.findByUuid(cust.getUuid());

        if (existingData.isEmpty()) {
            throw new Exception("Cannot update: Customer not found.");
        }

        existingData.get().setBalance(cust.getBalance());
        existingData.get().setPin(cust.getPin());
        existingData.get().setAccountFrozen(cust.isAccountFrozen());
        existingData.get().setId(cust.getId());
        existingData.get().setUsername(cust.getUsername());
        existingData.get().setPassword(cust.getPassword());
        return cust;
    }

    @Override
    public void deleteAccount(Customer cust) throws Exception {
        Optional<CustomerData> existingData = custDataRepository.findByUuid(cust.getUuid());

        if (existingData.isEmpty()) {
            throw new Exception("Cannot delete: Customer not found.");
        }

        custDataRepository.delete(existingData.get());
    }

    @Override
    public Administrator getAdminAccount(Integer id) throws Exception {
        Optional<AdministratorData> existingData = adminDataRepository.findById(id);
        if (existingData.isEmpty()) {
            throw new Exception("Cannot get: Admin not found.");
        }

        Administrator admin = new Administrator(existingData.get().getUuid(),
                "Admin",
                true,
                existingData.get().getUsername(),
                existingData.get().getPassword(),
                existingData.get().getId());
        return admin;
    }

    @Override
    public Customer getAccount(Integer id) throws Exception {
        Optional<CustomerData> existingData = custDataRepository.findById(id);
        if (existingData.isEmpty()) {
            throw new Exception("Cannot get: Customer not found.");
        }

        Customer customer  = new Customer(
                existingData.get().getUuid(),
                existingData.get().getUsername(),
                existingData.get().getPassword(),
                "Customer", false,
                existingData.get().getId(),
                existingData.get().getBalance(),
                existingData.get().getPin(),
                existingData.get().isAccountFrozen()
        );
        return customer;
    }

    @Override
    public Administrator[] getAdmins() throws Exception {
        List<AdministratorData> data = adminDataRepository.findAll();

        Administrator[] admins = data.stream().map(
                cust -> new Administrator(
                        cust.getUuid(),
                        "Admin",
                        true,
                        cust.getUsername(),
                        cust.getPassword(),
                        cust.getId()

                )).toArray(Administrator[]::new);
        return admins;
    }

    @Override
    public Administrator createAdminAccount(Administrator admin) throws Exception {
        AdministratorData admina = new AdministratorData();
        admina.setUuid(admin.getUuid());
        admina.setUsername(admin.getUsername());
        admina.setPassword(admin.getPassword());

        adminDataRepository.save(admina);
        return admin;
    }

    @Override
    public Administrator updateAdminAccount(Administrator admin) throws Exception {
        Optional<AdministratorData> existingData = adminDataRepository.findByUuid(admin.getUuid());

        if (existingData.isEmpty()) {
            throw new Exception("Cannot update: Admin not found.");
        }

        existingData.get().setId(admin.getId());
        existingData.get().setUsername(admin.getUsername());
        existingData.get().setPassword(admin.getPassword());
        adminDataRepository.save(existingData.get());
        return admin;
    }

    @Override
    public double checkBalance(Customer cust) throws Exception {
        Optional<CustomerData> existingData = custDataRepository.findByUuid(cust.getUuid());
        if (existingData.isEmpty()) {
            throw new Exception("Cannot get: Customer not found.");
        }

        return existingData.get().getBalance();
    }

    @Override
    public void depositMoney(Customer cust, double amount) throws Exception {
        Optional<CustomerData> existingData = custDataRepository.findByUuid(cust.getUuid());

        if (existingData.isEmpty()) {
            throw new Exception("Cannot update: Customer not found.");
        }

        existingData.get().setBalance(cust.getBalance() + amount);
        custDataRepository.save(existingData.get());
    }

    @Override
    public void withdrawMoney(Customer cust, double amount) throws Exception {
        Optional<CustomerData> existingData = custDataRepository.findByUuid(cust.getUuid());

        if (existingData.isEmpty()) {
            throw new Exception("Cannot update: Customer not found.");
        }

        existingData.get().setBalance(cust.getBalance() - amount);
        custDataRepository.save(existingData.get());
    }

    @Override
    public void transferMoney(Customer source, Customer destination, double amt) throws Exception {
        Optional<CustomerData> sourceData = custDataRepository.findByUuid(source.getUuid());
        Optional<CustomerData> destData = custDataRepository.findByUuid(destination.getUuid());
        if (sourceData.isEmpty() || destData.isEmpty()) {
            throw new Exception("Cannot update: Customer not found.");
        }

        destData.get().setBalance(destData.get().getBalance() + amt);
        custDataRepository.save(destData.get());
        sourceData.get().setBalance(source.getBalance() - amt);
        custDataRepository.save(sourceData.get());

    }
}
