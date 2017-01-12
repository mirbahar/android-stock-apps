package com.stock.rahat.stock.Entity;

/**
 * Created by rahat on 1/12/17.
 */

public class UserRegistration {
    private int id;
    private String fullName;
    private String username;
    private String email;

    public String getPassword() {
        return password;
    }

    private String password;

    public UserRegistration(int id, String fullName, String username, String email,String password) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserRegistration(String fullName, String username, String email,String password) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public UserRegistration(String username,String password) {

        this.username = username;
        this.password = password;
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
