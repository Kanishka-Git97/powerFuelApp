package com.powerfuel.powerFuelApp.model;


import javax.persistence.*;

@Entity
@Table(name="fuelRequests_tb")
public class FuelRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int request_id;
    int station_id;
    String request_date;
    String request_status;

    @OneToMany(mappedBy = "fuelRequests_tb",cascade = CascadeType.ALL,orphanRemoval = true)


    public int getRequest_id() {
        return request_id;
    }

    public int getStation_id() {
        return station_id;
    }

    public String getRequest_date() {
        return request_date;
    }

    public String getRequest_status() {
        return request_status;
    }


    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public void setRequest_date(String request_date) {
        this.request_date = request_date;
    }

    public void setRequest_status(String request_status) {
        this.request_status = request_status;
    }
}