package io.github.unawarespecs.bankapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Administrator extends User {
    public Administrator() {
        this.setRole("Administrator");
    }

    public Administrator(int id, String name) {
        // Username, password, and role are handled here.
        super(name, true);
        this.setRole("Administrator");
        this.setId(id);
    }

    @Override
    public String toString() {
        return String.format("Administrator[username=%s, id=%d, uuid=%s]", super.getUsername(), super.getId(),
                super.getUuid().toString());
    }
}
