package com.powerfuel.powerFuelApp.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.powerfuel.powerFuelApp.model.DataTraveler;
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

    @PostMapping("/register")

    public String registerNewStation(@RequestBody ObjectNode data){

        FuelStation newStation=new FuelStation();
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
        int id=data.get("id").asInt();
        String name=data.get("name").asText();
        String address=data.get("address").asText();
        String number=data.get("mobile").asText();
        String email=data.get("email").asText();
        double dieselCap=data.get("diesel_capacity").asDouble();
        double petrolCap=data.get("petrol_capacity").asDouble();
        String status=data.get("status").asText();
        int district=data.get("district").asInt();
        // public void updateStationData(String address,double diesel,int district,String email,String mobile,String name,double petrol,String status,int id);
        fuelstationservice.updateStationData(address,dieselCap,district,email,number,name,petrolCap,status,id);
        return "updated";
    }

    /*----Nearest Station details-----------*/
    @PostMapping(path = "/nearest", consumes = "application/x-www-form-urlencoded")
    public List<FuelStation> nearest(DataTraveler data){
        int id = Integer.parseInt(data.getId());
        return fuelstationservice.getNearestStations(id);
    }

    @PostMapping("/get")
    public FuelStation get(@RequestBody ObjectNode data){
        return fuelstationservice.getStation(data.get("id").asInt());
    }

    /*---------View All Station Details-------*/
    @PostMapping("/viewAll")
    public List<FuelStation>viewAllStations(){
        return fuelstationservice.getAllStationDetails();
    }

    /*-------------get single station by id------*/
    @PostMapping("/getSingleItem")
    public List<FuelStation> getSingleItemDetails(@RequestBody ObjectNode data){
        int station_id=data.get("id").asInt();
        return fuelstationservice.getSingleStationDetails(station_id);
    }


}
