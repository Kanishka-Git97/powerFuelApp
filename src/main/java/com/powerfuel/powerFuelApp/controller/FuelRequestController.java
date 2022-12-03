package com.powerfuel.powerFuelApp.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.powerfuel.powerFuelApp.model.FuelRequestDetails;
import com.powerfuel.powerFuelApp.model.FuelRequests;
import com.powerfuel.powerFuelApp.service.FuelRequestDetailsService;
import com.powerfuel.powerFuelApp.service.FuelRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;

@RestController
@RequestMapping("/fuelRequest")
@CrossOrigin
public class FuelRequestController {
    @Autowired
    private FuelRequestService fuelrequestservice;

    @Autowired
    private FuelRequestDetailsService fuelrequestdetailservice;


    FuelRequestDetails newDetails=new FuelRequestDetails();


    @PostMapping("/insert")
    public String createRequest(@RequestBody ObjectNode data){

        FuelRequests newRequest=new FuelRequests();
        int station_id=data.get("station_id").asInt();
        String request_date=data.get("request_date").asText();
        String request_status=data.get("request_status").asText();

        /*----Setters---Fuel Request Table---*/
        newRequest.setStation_id(station_id);
        newRequest.setRequest_date(request_date);
        newRequest.setRequest_status(request_status);

        /*-------Create New Request-row-----*/
        fuelrequestservice.insertFuelRequest(newRequest);

//        int request_id=data.get("request_id").asInt();
//        int batch_num=data.get("batch_num").asInt();
//        int request_quantity=data.get("request_quantity").asInt();
//        int received_quantity=data.get("received_quantity").asInt();
//        double unit_price=data.get("unit_price").asDouble();
//        String fuel_type=data.get("fuel_type").asText();
//        String status=data.get("status").asText();

        /*----Setter Fuel Request Detail Table----*/
//        newDetails.setRequest_id(request_id);
//        newDetails.setBatch_num(batch_num);
//        newDetails.setRequested_quantity(request_quantity);
//        newDetails.setReceived_quantity(received_quantity);
//        newDetails.setUnit_price(unit_price);
//        newDetails.setFuel_type(fuel_type);
//        newDetails.setStatus(status);

        /*----create new request detail row-----*/
//        fuelrequestdetailservice.insertRequestDetails(newDetails);








        return "success";
    }



}
