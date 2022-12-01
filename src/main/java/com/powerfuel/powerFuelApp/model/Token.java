package com.powerfuel.powerFuelApp.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customer_que")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private Integer user;
    private double qty;
    @Column(name="requested_at")
    private Date requestedAt;
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

    public Integer getUser() {
        return user;
    }

    public Date getRequestedAt() {
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

    public void setUser(Integer user) {
        this.user = user;
    }

    public void setRequestedAt(Date requestedAt) {
        this.requestedAt = requestedAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

}