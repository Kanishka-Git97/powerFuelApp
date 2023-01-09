package com.powerfuel.powerFuelApp.model;
import javax.persistence.*;

@Entity
@Table(name = "access_tbl")

public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private int code;
    private String name;
    private String status;

     //Getters
     public int getId() {
        return id;
    }
    public int getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public String getStatus() {
        return status;
    }

     //Setters
     public void setId(int id) {
        this.id = id;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(String status) {
        this.status = status;
    }





}
