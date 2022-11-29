package com.powerfuel.powerFuelApp.model;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class DataTraveler {
    String id;
    String email;
    String password;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
