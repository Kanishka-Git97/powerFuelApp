package com.powerfuel.powerFuelApp.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customer_que")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private Integer vehicle;
    private double qty;
    @Column(name="requested_at")
    private String requestedAt;
    private String status;
    @Column(name="update_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updateAt;

    public Integer getId() {
        return id;
    }

    public double getQty() {
        return qty;
    }

    public String getStatus() {
        return status;
    }

    public Integer getVehicle() {
        return vehicle;
    }

    public String getRequestedAt() {
        return requestedAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setVehicle(Integer vehicle) {
        this.vehicle = vehicle;
    }

    public void setRequestedAt(String requestedAt) {
        this.requestedAt = requestedAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

}