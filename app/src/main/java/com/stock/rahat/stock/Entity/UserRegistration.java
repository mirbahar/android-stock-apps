package com.stock.rahat.stock.Entity;

import java.io.Serializable;

/**
 * Created by rahat on 1/12/17.
 */

public class UserRegistration implements Serializable {
    public int getId() {
        return this.id;
    }

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
    public UserRegistration(int id, String fullName, String username, String email) {
        this.id = id;
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
