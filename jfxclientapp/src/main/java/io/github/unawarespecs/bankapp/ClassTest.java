package io.github.unawarespecs.bankapp;

import io.github.unawarespecs.bankapp.model.Administrator;
import io.github.unawarespecs.bankapp.model.Customer;

public class ClassTest {
    public static void main(String[] args) {
        Customer c = new Customer();
        c.setId(1);
        c.setUsername("test");
        c.setPin(7013);
        c.setBalance(1234567.89);

        Administrator a = new Administrator();
        a.setId(2);
        a.setUsername("test");

        System.out.println(c);
        System.out.println(a);
        System.exit(0);
    }
}
