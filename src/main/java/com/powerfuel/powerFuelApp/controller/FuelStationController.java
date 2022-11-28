package com.powerfuel.powerFuelApp.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.powerfuel.powerFuelApp.model.FuelStation;
import com.powerfuel.powerFuelApp.service.FuelStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/fuelstation")
@CrossOrigin
public class FuelStationController {
    @Autowired
    private FuelStationService fuelstationservice;
    FuelStation newStation=new FuelStation();
    @PostMapping("/register")

    public String registerNewStation(@RequestBody ObjectNode data){


        int validateAccountStatus=fuelstationservice.validateStation(data.get("email").asText());
        if(validateAccountStatus==0){
            newStation.setName(data.get("name").asText());
            newStation.setAddress(data.get("address").asText());
            newStation.setMobile(data.get("mobile").asText());
            newStation.setEmail(data.get("email").asText());
            newStation.setDieselCapacity(data.get("diesel_capacity").asDouble());
            newStation.setPetrolCapacity(data.get("petrol_capacity").asDouble());
            newStation.setStatus(data.get("status").asText());
            newStation.setDistrict(data.get("district").asInt());
            fuelstationservice.registerFuelStation(newStation);

        }else{
            return "Account Already Exist";
        }
        /*----validate the registration----*/

        return "success";
    }

    /*----Update Station details-----------*/

    @PostMapping("/update")
    public String updateStation(@RequestBody ObjectNode data){
        String name=data.get("name").asText();
        String mobile=data.get("mobile").asText();
        double diesel_capacity=data.get("diesel_capacity").asDouble();
        double petrol_capacity=data.get("petrol_capacity").asDouble();
        String status=data.get("status").asText();
        String email=data.get("email").asText();
        fuelstationservice.updateStationData(name,mobile,diesel_capacity,petrol_capacity,status,email);
        return "updated";
    }

    /*----Nearest Station details-----------*/
    @PostMapping("/nearest")
    public List<FuelStation> nearest(@RequestBody ObjectNode data){
        return fuelstationservice.getNearestStations(data.get("district").asInt());

    }

}
