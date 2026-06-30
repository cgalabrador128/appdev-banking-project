package io.github.unawarespecs.bankapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Customer extends User {
    private double balance;
    private int pin;
    boolean isAccountFrozen;

    public Customer() {
        this.balance = 0.0;
        // Default PIN of 1234
        this.pin = 1234;
        this.isAccountFrozen = false;
        this.setRole("Customer");
    }

    public Customer(int id, String name) {
        // Username, password, and role are handled here.
        super(name, false);
        this.setId(id);
        this.setRole("Customer");
        this.balance = 0.0;
        // Default PIN of 1234 (must be changed)
        this.pin = 1234;
        this.isAccountFrozen = false;
    }

    @Override
    public String toString() {
        return String.format("Customer[username=%s, id=%d, uuid=%s, balance=%,.2f]",
                super.getUsername(), super.getId(), super.getUuid().toString(), balance);
    }
}
