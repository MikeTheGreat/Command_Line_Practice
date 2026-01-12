package com.example.models;

public class User {
    private String username;
    private String email;
    private int age;

    // TODO: Add validation for email format
    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    // BUG: This method doesn't check for negative ages
    public int getAge() {
        return age;
    }

    public boolean isAdult() {
        return age >= 18;
    }
}
