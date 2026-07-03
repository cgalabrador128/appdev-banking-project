package io.github.unawarespecs.bankapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class Customer extends User {
    private double balance;
    private int pin;
    boolean isAccountFrozen;

    public Customer(){
        super();
        this.setRole("Customer");
        this.setId(0); // ID CANNOT BE 0 THIS WILL BE CHANGED LATER ON IF NOT EXPLICITEDLY IMPLEMENTED
        this.balance = 0;
        this.pin = 1234;
        this.isAccountFrozen = false;
    }
    public Customer(UUID uuid, String username, String password, String role, boolean isAdmin, int id, double balance, int pin, boolean frozen) {
        // Username, password, and role are handled here.
        super(uuid, role, isAdmin);
        this.setUsername(username);
        this.setPassword(password);
        this.setId(id);
        this.setRole(role);
        this.balance = balance;
        // Default PIN of 1234 (must be changed)
        this.pin = pin;
        this.isAccountFrozen = frozen;
    }

    @Override
    public String toString() {
        return String.format("Customer[username=%s, id=%d, uuid=%s, balance=%,.2f]",
                super.getUsername(), super.getId(), super.getUuid().toString(), balance);
    }
}
