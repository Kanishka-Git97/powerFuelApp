package com.powerfuel.powerFuelApp.model;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String registration;
    private String chassis;
    @Column(name = "available_quota")
    private double availableQuota;
    @Column(name = "vehicle_type")
    private int vehicleType;
    @Column(name = "fuel_type")
    private int fuelType;


    public Integer getId() {
        return id;
    }

    public String getRegistration() {
        return registration;
    }

    public String getChassis() {
        return chassis;
    }

    public double getAvailableQuota() {
        return availableQuota;
    }

    public int getFuelType() {
        return fuelType;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public void setAvailableQuota(double availableQuota) {
        this.availableQuota = availableQuota;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setFuelType(int fuelType) {
        this.fuelType = fuelType;
    }
}