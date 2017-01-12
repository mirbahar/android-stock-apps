package com.stock.rahat.stock.Entity;

/**
 * Created by rahat on 1/12/17.
 */

public class UserRegistration {
    private int id;
    private String fullName;
    private String username;
    private String email;

    public UserRegistration(int id, String fullName, String username, String email) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
    }

    public UserRegistration(String fullName, String username, String email) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
    }

    public UserRegistration() {

    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
