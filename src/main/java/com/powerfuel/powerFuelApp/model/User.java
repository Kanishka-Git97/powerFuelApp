package com.powerfuel.powerFuelApp.model;
import javax.persistence.*;

@Entity
@Table(name = "user_registration")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private String company_type;
    private String user_name;
    private String password;
    private String designation;
    private String role;
    private String status;


    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCompanyType() {
        return company_type;
    }
    public String getUserName() {
        return user_name;
    }
    public String getPassword() {
        return password;
    }
    public String getDesignation() {
        return designation;
    }
    public String getRole() {
        return role;
    }
    public String getStatus() {
        return status;
    }
    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCompanyType(String company_type) {
        this.company_type = company_type;
    }
    public void setUserName(String user_name) {
        this.user_name = user_name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}



