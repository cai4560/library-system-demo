package com.thoughtworks.library.model;

import java.util.Arrays;

public enum Role {
    ADMIN("admin"),
    USER("user"),
    UNKNOWN("unknown");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static Role parse(String name) {
        return Arrays.stream(values())
                .filter(role -> role.getName().equals(name))
                .findFirst().orElse(UNKNOWN);
    }
}
