package com.powerfuel.powerFuelApp.model;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String timeSlot;
    private int tokenRef;

    public int getId() {
        return id;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public int getTokenRef() {
        return tokenRef;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public void setTokenRef(int tokenRef) {
        this.tokenRef = tokenRef;
    }
}