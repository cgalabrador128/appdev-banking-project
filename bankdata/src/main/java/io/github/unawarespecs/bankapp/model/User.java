package io.github.unawarespecs.bankapp.model;

import lombok.Data;
import java.util.UUID;

@Data
public class User {
    // Unique account identifiers.
    private int id;
    private UUID uuid;

    // Auth stuff.
    private String username;
    private String password;

    // User role (isAdmin = true: Administrator; otherwise Customer)
    boolean isAdmin;
    private String role;

    @Override
    public String toString() {
        return String.format("User[username=%s, id=%d, uuid=%s]", username, id, uuid);
    }

    public User() {
        this.role = "User";
        this.uuid = UUID.randomUUID();
        this.isAdmin = false;
    }

    public User(String username, boolean isAdmin) {
        this.username = username;
        this.isAdmin = isAdmin;
        this.role = "User";
        this.uuid = UUID.randomUUID();
    }

}
