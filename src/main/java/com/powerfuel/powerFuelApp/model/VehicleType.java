package com.powerfuel.powerFuelApp.model;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_type")
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String type;
    private double quota;

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getQuota() {
        return quota;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuota(double quota) {
        this.quota = quota;
    }
}