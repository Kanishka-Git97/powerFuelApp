package com.powerfuel.powerFuelApp.model;

import javax.persistence.*;

@Entity
@Table(name = "fuel_station")
public class FuelStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private String address;
    private String mobile;
    private String email;

    @Column(columnDefinition = "varchar(50) default 'open'")
    private String status;
    private double petrol_capacity;
    private double diesel_capacity;

    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getMobile() {
        return mobile;
    }
    public String getEmail() {
        return email;
    }
    public String getStatus() {
        return status;
    }
    public double getPetrolCapacity() {
        return petrol_capacity;
    }
    public double getDieselCapacity() {
        return diesel_capacity;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setPetrolCapacity(double petrolCapacity) {
        this.petrol_capacity = petrolCapacity;
    }
    public void setDieselCapacity(double dieselCapacity) {
        this.diesel_capacity = dieselCapacity;
    }
}