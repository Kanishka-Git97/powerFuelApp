package com.powerfuel.powerFuelApp.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.powerfuel.powerFuelApp.model.Vehicle;
import com.powerfuel.powerFuelApp.model.VehicleType;
import com.powerfuel.powerFuelApp.service.VehicleService;
import com.powerfuel.powerFuelApp.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {
    @Autowired
    private VehicleService service;
    @Autowired
    private VehicleTypeService vehicleTypeService;

    @PostMapping("/get")
    public Vehicle get(@RequestBody ObjectNode data){
        return service.getVehicle(data.get("id").asInt());
    }

    @PostMapping("/add")
    public String add(@RequestBody Vehicle vehicle){

        VehicleType selectedType = vehicleTypeService.get(vehicle.getVehicleType());
        //Update Vehicle Quota
        vehicle.setAvailableQuota(selectedType.getQuota());
        return service.save(vehicle);
    }

    @PostMapping("/vehicles")
    public List<Vehicle> vehicles(@RequestBody ObjectNode data){
        return service.getVehiclesByOwner(data.get("id").asInt());
    }

    @GetMapping("/refreshfuel")
    public String updateFuel(){
        return service.updateFuel();
    }

}
