package com.powerfuel.powerFuelApp.model;

import javax.persistence.*;

@Entity
@Table(name="fuelRequest_details_tb")
public class FuelRequestDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int requestDetail_id;
    int request_id;
    int batch_num;

    @Column(columnDefinition = "integer default 0")
    int requested_quantity;



    @Column(columnDefinition = "integer default 0")
    int received_quantity;

    @Column(columnDefinition = "integer default 0")
    int dispatched_quantity;
    double unit_price;
    String fuel_type;
    String status;

    public void setDispatched_quantity(int dispatched_quantity) {
        this.dispatched_quantity = dispatched_quantity;
    }

    public int getDispatched_quantity() {
        return dispatched_quantity;
    }

    public int getRequestDetail_id() {
        return requestDetail_id;
    }

    public int getRequest_id() {
        return request_id;
    }

    public int getBatch_num() {
        return batch_num;
    }

    public int getRequested_quantity() {
        return requested_quantity;
    }

    public int getReceived_quantity() {
        return received_quantity;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public String getStatus() {
        return status;
    }

    public void setRequestDetail_id(int requestDetail_id) {
        this.requestDetail_id = requestDetail_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public void setBatch_num(int batch_num) {
        this.batch_num = batch_num;
    }

    public void setRequested_quantity(int requested_quantity) {
        this.requested_quantity = requested_quantity;
    }

    public void setReceived_quantity(int received_quantity) {
        this.received_quantity = received_quantity;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
