package com.powerfuel.powerFuelApp.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.powerfuel.powerFuelApp.model.FuelRequestDetails;
import com.powerfuel.powerFuelApp.model.FuelRequests;
import com.powerfuel.powerFuelApp.service.FuelRequestDetailsService;
import com.powerfuel.powerFuelApp.service.FuelRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fuelRequest")
@CrossOrigin
public class FuelRequestController {
    @Autowired
    private FuelRequestService fuelrequestservice;

    @Autowired
    private FuelRequestDetailsService fuelrequestdetailservice;


    @PostMapping("/insert")
    public String createRequest(@RequestBody ObjectNode data){
        FuelRequests newRequest=new FuelRequests();
        FuelRequestDetails newDetails=new FuelRequestDetails();
        List<FuelRequests> data1;

        int station_id=data.get("station_id").asInt();
        String request_date=data.get("request_date").asText();
        String request_status=data.get("request_status").asText();
        int batch_num=data.get("batch_num").asInt();
        int request_quantity=data.get("requested_quantity").asInt();
        int received_quantity=data.get("received_quantity").asInt();
        int dispatched_quantity=0;
        double unit_price=data.get("unit_price").asDouble();
        String fuel_type=data.get("fuel_type").asText();
        String status=data.get("request_status").asText();

        /*------Check Open Requests for current station id---*/
        int validateAvailability=fuelrequestservice.validateStationRequest(station_id);
        System.out.print(validateAvailability);
        if(validateAvailability==0){
            /*---insert into fuel requests table-----*/
            newRequest.setStation_id(station_id);
            newRequest.setRequest_date(request_date);
            newRequest.setRequest_status(request_status);
            /*----insert data ino--request table-----*/
            fuelrequestservice.insertFuelRequest(newRequest);
            /*------get request id--------------------*/
            int request_id= fuelrequestservice.getRequestId(station_id);

            newDetails.setRequest_id(request_id);
            newDetails.setBatch_num(batch_num);
            newDetails.setRequested_quantity(request_quantity);
            newDetails.setReceived_quantity(received_quantity);
            newDetails.setDispatched_quantity(dispatched_quantity);
            newDetails.setUnit_price(unit_price);
            newDetails.setFuel_type(fuel_type);
            newDetails.setStatus(status);
            newDetails.setFuelRequests(newRequest);

            fuelrequestdetailservice.insertRequestDetails(newDetails);

            return "success";

        }else{
            /*-------get request id for the second time data insert------*/
            int request_id= fuelrequestservice.getRequestId(station_id);
            List<Object> pendingTypes=fuelrequestdetailservice.getPendingList(request_id);
            /*--------Get Pending Details From Fuel Requests------*/
            List<FuelRequests> currentRequestDetails=fuelrequestservice.getPendingDetails(station_id);
            FuelRequests examplData=currentRequestDetails.get(0);
//            int fetched_station_id=examplData.getStation_id();
//            int fetched_request_id=examplData.getStation_id();
//            String fetched_request_date=examplData.getRequest_date();
//            String fetched_request_status=examplData.getRequest_status();

            if(pendingTypes.size()==1){
                newDetails.setRequest_id(request_id);
                newDetails.setBatch_num(batch_num);
                newDetails.setRequested_quantity(request_quantity);
                newDetails.setReceived_quantity(received_quantity);
                newDetails.setDispatched_quantity(dispatched_quantity);
                newDetails.setUnit_price(unit_price);
                newDetails.setFuel_type(fuel_type);
                newDetails.setStatus(status);

                /*-----Initialize fetched Requests Data to requests details table----*/

                newDetails.setFuelRequests(examplData);


                fuelrequestdetailservice.insertRequestDetails(newDetails);
                return "second success";


            }




        }


       return "abort";
    }


    /*-----get all Data by Id----*/
    @PostMapping("/fetch")
    List<FuelRequestDetails> viewAllItemsById(@RequestBody ObjectNode data){
        int station_id=data.get("station_id").asInt();
        return fuelrequestdetailservice.viewAllRequestsByStationId(station_id);
    }



}